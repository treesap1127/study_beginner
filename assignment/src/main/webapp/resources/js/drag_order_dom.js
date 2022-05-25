class DragOrder {
    constructor (selector, direction) {// 가장 먼저 인스턴스 객체들을 지정해주는 코드!!!--> 저장 공간 통을 먼저 만들어준다!
        this.list = [];// tbody 리스트 배열 생성
        const root = document.querySelector(selector);
        root.querySelectorAll(".dragItem").forEach((item, index) => {  //tr 갯수대로 반복               
            item.setAttribute("draggable", true);// drag 가능하게..
            item.dataset["order"] = index + 1;// 여기서 dataset 으로 해당순번을 정해줌
            this.list.push(item);// tr을 list에 담아내기
        });
        this.list.forEach(item => {
            // 드래그 시작 이벤트 핸들러
            item.addEventListener("dragstart", e => {
				const target = e.target.closest(".dragItem"); // 해당 tr 가져오기
                console.log(`dragStart: ${target.dataset["order"]}`);//드래그 시작하면 저장!// 순서값 order 를 저장
                this.source = target;//e.dataTransfer.setData('text/plain', target.dataset["order"]);// 드래그 중인 데이터를 표시
                target.classList.add("dragStart");// dragStart 클래스 추가
            });
            // 드래그 아이템이 영역에 들어오는 이벤트 핸들러
            item.addEventListener("dragenter", e => {
				const target = e.target.closest(".dragItem");
                console.log(`dragEnter: ${target.dataset["order"]}`);
                // e.preventDefault();
                target.classList.add("dragOver");
            });
            // 드래그 아이템이 영역에 오버하는 이벤트 핸들러
            item.addEventListener("dragover", e => {
				const target = e.target.closest(".dragItem");
                console.log(`dragOver: ${target.dataset["order"]}`);
                // dragover 에서 이벤트 버블링을 캔슬링 해야 drop 이벤트 발생
                e.preventDefault();//오버하면 이벤트를 중지 시키는!!-> 중요!!
            });
            // 드래그 아이템이 영역에서 나가는 이벤트 핸들러
            item.addEventListener("dragleave", e => {
				const target = e.target.closest(".dragItem");
                console.log(`dragLeave: ${target.dataset["order"]}`);
                target.classList.remove("dragOver");//해당 드래그 영역에서 사라졌으니 클래스 삭제..
            });
            // 드래그 아이템이 드랍 되는지 상관없이 종결되는 이벤트 핸들러
            item.addEventListener("dragend", e => {
				const target = e.target.closest(".dragItem");
                console.log(`dragEnd: ${target.dataset["order"]}`);
                target.classList.remove("dragStart");
            });
            // 드래그 아이템이 드랍 되는 이벤트 핸들러
            item.addEventListener("drop", e => {
				const target = e.target.closest(".dragItem");//타겟을 바꾼 위치로 취하고
                console.log(`drop: ${target.dataset["order"]}`);
                target.classList.remove("dragOver");//이제 드랍 했으니 draOver 지우고
                this.target = target;// tr타겟을 target에 담아서 바꿀 준비!
                //const sourceOrder = e.dataTransfer.getData('text/plain');
                //const targetOrder = target.dataset["order"];                
                console.log(`${this.source.dataset["order"]} ====>>> ${this.target.dataset["order"]}`);
                this.moveOrder();
            });
        	
        });
    }
    moveOrder() {	//결국 도착 지점 말하는거 같은데
	//source=데이터 시작 지점 -  taget=데이터 도착지점
        const source_ = parseInt(this.source.dataset["order"]);//source_ 데이터값 order를 담음
        const target_ = parseInt(this.target.dataset["order"]);//target_ 데이터값 order를 담음
        this.list.forEach( item => {
	//테이블에 각 tr 만큼 각 tr 담아서 반복
            const order = parseInt(item.getAttribute("data-order"));//item 값에 data-order가져오기
            if(source_ < target_) {//해당 원래 기존 가지고 있던 source->기존 위치 가 target->바뀐 위치보다 작으면
			 this.target.parentNode.insertBefore(this.source, this.target.nextSibling);//부모의 앞에 저장 시키는데..
			//tbody에 타겟tr에 
                if(order == source_)// order=item으로 가져온 tr 값 == source 값과 같다면 그대로 data-order을 target에 저장
                    item.setAttribute("data-order", target_);
                else if(order > source_ && order <= target_)
                    item.setAttribute("data-order", order - 1);//작다면 -1 해줌 
            } 
			else {//크면!!
                this.target.parentNode.insertBefore(this.source, this.target);
                if(order == source_)
                    item.setAttribute("data-order", target_);                    
                else if(order < source_ && order >= target_)
                    item.setAttribute("data-order", order + 1);
            }//그니까 이건 옮긴 값이 자기 위치 보다 크거나 작으면 자기 값이 동일 하지 않으면 하나씩 빼주거나 올려주는 코드다!
        });}}
function check(){
	var numlast=$(`tbody`).children().last().attr("data-order");// tbody에 있는 data-order값
	for(i=0;i<numlast;i++){				//data-order값 갯수 만큼 반복
	var numitem=$("tbody").children().eq(i).children(":first").text();
	//tbody에서 n번째 자식의 첫번째 자식 텍스트==고객번호
	
	var item={num:parseInt(numitem),rnum:parseInt(i)};
	//num=고객번호 rnum는 순번
	console.log(`${item.num}=고객번호 ${item.rnum}=순번`);
	$.ajax("/order",{//ajax로 Requestmapping 된 order로 연결
		          method: "POST",
          		  contentType: "application/json",
		          dataType: "json",
		          data: JSON.stringify(item),//Json 타입으로 변경한 item 객체를 보냄 
		          success: result => {// 결과값 가져옴
		            console.log("결과값"+result);
					$(".test").text("적용이 완료되었습니다");//적용을 알림
		 		   },
		       error: (xhr, result) => console.log(`[실패] print`)
		       });
	}
}