# java-lotto

## 기능 목록
- 사용자 입력
    - [x] 구매할 금액 입력
    - [x] 수동으로 구매할 로또 수 입력
    - [ ] 수동으로 구매할 로또 번호 입력
    - [x] 입력된 번호로 수동 로또 생성
    - [ ] 당첨번호 입력
    - [ ] 보너스 번호 입력
- [x] 로또 자동 생성
- [x] 구입한 로또 출력
- 결과
    - [ ] 두개의 로또 비교
    - [ ] n 개의 로또 비교
    - [ ] 수익 계산
    
## 예외
- 구매할 금액 입력시
    - [x] 숫자가 아닌 문자 입력
    - [x] 1000원 이하의 금액 입력

- 수동으로 구매할 로또 입력시
  - [ ] 숫자가 아닌 문자 입력
  - [x] 구매 가능한 수보다 큰 수 입력

- 로또 생성시
  - [x] 6개의 숫자가 아닐때
  - [x] 숫자가 중복될 때
- [x] LottoNo 의 toLotto에 1~45 이외의 숫자가 입력