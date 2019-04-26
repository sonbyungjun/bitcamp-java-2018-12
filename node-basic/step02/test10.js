/* 주제: 연산자 - 비트 연산자
- 비트 단위로 AND, OR, XOR 연산 수행
- 문법
a & b (AND; 둘 다 1일 때만 1, 그밖에 0)
a | b (OR; 둘 중 하나라도 1이면 1, 그밖에 0)
a ^ b (Exclusive OR; 두 개의 값이 다르면 1, 같으면 0)
~a (비트 not; 모든 비트는 반대 값으로 바꾼다.)
*/
"use strict"
var a = 10; // 0000 0000 0000 0000 0000 0000 0000 1010
var b = 12; // 0000 0000 0000 0000 0000 0000 0000 1100

console.log("a & b =", a & b); // 0000 0000 0000 0000 0000 0000 0000 1000
console.log("a | b =", a | b); // 0000 0000 0000 0000 0000 0000 0000 1110
console.log("a ^ b =", a ^ b); // 0000 0000 0000 0000 0000 0000 0000 0110
console.log("~a =", ~a); // 1111 1111 1111 1111 1111 1111 1111 0101

// AND의 사용
// - 색상의 변화나 색조 변경시 사용
// - 그림에서 특정 영역의 값을 필터링 또는 마스킹 할 때 사용한다.
// 예) RGB 값 중에서 red와 blue 색을 없애는 기법
var pixel = 0x34f588; // 00110100 11111010 10001000
var mask = 0x00ff00;  // 00000000 11111111 00000000
console.log((pixel & mask).toString(16)); // 00000000 11111010 00000000


// OR의 사용
// - 기존 색상을 강화할 때 사용한다.
// 예) 어떤 픽셀에 대해 빨간색을 강화해보자!
var pixel = 0x34f588; // 00110100 11111010 10001000
var mask = 0xaa0000;  // 10101010 00000000 00000000
console.log((pixel | mask).toString(16)); // 10111110 11111010 10001000

// XOR의 사용
// - 배경 사진과 사람이 들어간 상태의 배경 사진을 XOR 하면
//   원래 있던 배경 사진, 즉 같은 값은 0으로 제거되고 다른 값만 남게 된다.
//   크로마킹 기법을 처리할 때 사용한다.
// 예) rgb 픽셀의 값이 같을 경우 제거하기
var pixel = 0x34f588; // 00110100 11111010 10001000
var mask = 0x34f588;
console.log((pixel ^ mask).toString(16));
console.log("-----------------------");










//
