package com.racing.web.service.dto;

public record StartRaceRequest(String carNames, int tryCount) {
}


 ////spring 직렬화 역질력화 //
//common 스프링관련된게 없어야 한다
// Bean은 웹에만 해야한다.
// 이것을 확실히 이해해야한다 콘솔과 웹에 차이랑
// // 스프링라이브러리에 콘솔이 의존하면 안될까

// 계층 이해핤 ㅜ있어야한다.

