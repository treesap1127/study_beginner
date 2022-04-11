const state = {
   page: 1
};

const header = [];//배열만듬

function makeItem(item) {//아이템 만들기! 바디 라인 만드는거!
      
   /*
   const {code, name, spec, manufacture, category, price, barcode} = item;
   */
      
   let html = `<tr class="item" data-code="${item[pager_key]}">`;// ${item[code]}
   
   html+= `<td><input type="checkbox" class="form-check-input item-check" value="${item[pager_key]}"></td>`;
   
   for(let i=0; i < header.length; i++) {
      let value_ = "";
      console.log(header);
		console.log(header[1]);
      if(item[header[i]])
         value_ = item[header[i]];
      
      html += `<td class="${header[i]}">${value_}</td>`;
   }
   // <td class="code">${code}</td><td class="barcode">${barcode_}</td><td class="name">${name}</td><td class="spec">${spec}</td><td class="category">${category}</td><td class="manufacture">${manufacture}</td><td class="price">${price}</td>`;
   
   html += `<td><div class="btn btn-sm btn-danger delete">삭제</div> <div class="btn btn-sm btn-warning update">변경</div></td></tr>`;

   return html;
}
//페이지 만드는거!
function movePage(page) {
   state.page = page;
   
   $.ajax(pager_url, {
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        data: state, 
        success: result => {
            const {list, pager} = result;

         $(`${pager_root} thead input[type='checkbox']`).prop("checked", false);

         $(`${pager_root} th i`).remove();
         if(pager.orderMode != 0) {
            const icon = $("<i>");
            
            if(pager.orderMode == 1)
               icon.addClass("bi bi-caret-up");
            else
               icon.addClass("bi bi-caret-down");
               
            $(`${pager_root} th[data-order='${pager.order}']`).prepend(icon); 
         }

         $("#search .perPage").val(pager.perPage);

         state.total = pager.total;
         $("#total").text(state.total);
   //이게 한줄 씩 만드는코드
         if(list && list.length > 0) {
            $(`${pager_root} .empty_msg`).addClass("hide");
            
            const tbody =  $(`${pager_root} tbody`);
            
               let html = "";
               for(let i=0; i < list.length; i++)
               html += makeItem(list[i]);
                              
            $(`${pager_root} tr.item`).remove();
            
            tbody.append(html);
            // $(`${pager_root}`).append(tbody);                  
         } //이게 다 만들면 ㅇㅇ
		else {
            $(`${pager_root} .empty_msg`).removeClass("hide");
            $(`${pager_root} tr.item`).remove();
         }

         $(`${pager_root} .page-prev`).data("page", pager.prev);   
         $(`${pager_root} .page-next`).data("page", pager.next);
         $(`${pager_root} .page-last`).data("page", pager.last);
         
         $(`${pager_root} .page-list`).remove();
         
         const pageList = pager.list;            
         for(let i=0; i < pageList.length; i++) {
            const page_item = $("<div>").addClass("page-item page-list");
            
            if(pager.page == pageList[i])
               page_item.addClass("active");
               
            const page_link = $("<div>").addClass("page-link");
            page_link.text(pageList[i]);
            page_link.attr("data-page", pageList[i]);
            
            page_item.append(page_link);
            
            $(`${pager_root} .page-next`).parent().before(page_item);
         }
},
        error: xhr => alert(`오류 발생: ${xhr.statusText}`)
    });
}
//검색 함수
function search() {
   const search = $("#search .search").val();
   const keyword = $("#search .keyword").val();
   
   if(search != 0 && keyword == "") {
      alert("검색어를 입력 해 주세요");
      $("#search keyword").focus();
      return;
   }
   
   state.search = search;
   state.keyword = keyword;
   
   movePage(1);
}

$(function() {// 온 로드! 처음 시작 
//페이지 삭제 - 여러가지!
   $("#delete_list").click(function(){
      const list = $(`${pager_root} .item-check:checked`).get();

      const selected = list.map(item => item.value);

      $.ajax(`${pager_url}/delete/list`, {
         method: "POST",
         contentType: "application/json",
         dataType: "json",
         data:JSON.stringify(selected),
         success: () => movePage(1),
         error: xhr => alert(`오류 발생: ${xhr.statusText}`)
      });

   });
//체크해서 한번에 삭제
   $(`${pager_root} thead input[type='checkbox'] `).on("change",function(){
      const checked =$(this).prop("checked");

      $(`${pager_root} .item-check`).prop("checked",checked);
   });

   $(`${pager_root} th.order`).each( (index, item) => {
      header.push( $(item).data("name") );//item= table값 가져온거네 data-name 을 가져왔네 뭐하러..? 반복해서 쑤셔 박았다는데 인덱스에 있긴함!
   });
   //order
   $(`${pager_root} th.order`).click(function() {
      
      if(state.order == $(this).data("order"))
         state.orderMode = ++state.orderMode % 3;//같은곳 클릭시 +1 하는데 나누기 3이라 012 밖에 안나옴 ㄹㅇㅋㅋ   
      else {
         state.order = $(this).data("order");
         state.orderMode = 1;// 아직 선택 되기 전이면 넣고 보여주면 됨
      }
      
      movePage(1);
   });

   $("#search .perPage").on("change", function() {
      state.perPage = $(this).val();
      movePage(1);   
   });
   //엔터치면 등록 ㅇㅇ
   $("#search .keyword").on("keypress", function(event) {
      if(event.keyCode == 13) {
         search();
      }
   });

   $("#search .search").on("change", function() {
      if($(this).val() == 0) {
         $("#search .keyword").val("");
         search();
      }
   });
   
   $("#search .submit").click(function() {
      search();
   });

   $(`${pager_root}`).on("click", ".update", function() {
      
      header.forEach(value => {
         const text = $(this).parent().siblings(`.${value}`).text();
            $(`#updateModal .${value}`).val(text);
      });
      
      $("#updateModal").modal("show");   
   });
   //업데이트 모달 실행시
   $("#updateModal .update").click(function() {
      const item = {};
         header.forEach(value => item[value] = $(`#updateModal .${value}`).val());
      
      
      $("#updateModal input").val("");
      $("#updateModal").modal("hide");
      
      $.ajax(pager_url, {
         method: "PUT",
         contentType: "application/json",
         dataType: "json",
         data: JSON.stringify(item),
         success: function(result) {
            for(prop in result) {               
               $(`tr[data-code='${item.code}'] .${prop}`).text( result[prop] );
            }
         },
         error: xhr => alert(`오류 발생: ${xhr.statusText}`)
      });
   });
     //모달 클릭시 함수  
$("#addModal .add").click(function() {
      const item = {};
     
      header.forEach(value => item[value] = $(`#addModal .${value}`).val());
    
      //제품등록..?
      $("#addModal input").val(""),
      
      $.ajax(pager_url, {
         method: "POST",
         contentType: "application/json",
         dataType: "json",
         data: JSON.stringify(item),
         success: function(result) {
           const html = makeItem(result);//이게 페이지만드는건데
                      
             $(`${pager_root} tbody`).prepend(html);
  
           $("#total").text(++state.total);
         },
         error: xhr => alert(`오류 발생: ${xhr.statusText}`)
      });
      
      $("#addModal").modal("hide");
    });
//페이저
   $(`${pager_root} tfoot`).on("click", ".page-link", function() {
      const page = $(this).data("page");
      
      movePage(page);
   });
   //삭제
   $(`${pager_root}`).on("click", ".delete", function() {
      const code = $(this).parent().parent().data("code");
      
      $.ajax(`${pager_url}/${code}`, {
         method: "DELETE",
         contentType: "application/json",
         dataType: "json",
         success: result => {
            if(code === result) {
               $(`tr[data-code='${code}']`).remove();
               
               $("#total").text(--state.total);
            }
         },      
         error: xhr => alert(`오류 발생: ${xhr.statusText}`)   
      });
      
   });
   //무브 페이지! 페이지 이동!
   movePage(1);
});