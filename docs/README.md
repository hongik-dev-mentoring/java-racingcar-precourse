InputClass 구현
입력기능: ReadCarName, ReadTryNum
예외처리기능: StringHandlingException, IntHandlingException

- 자동차이름 이름 5자 초과로 들어올때
- 횟수에 숫자가 안들어올때
  getCarNum기능: 입력된 자동차의 개수반환

Car 구현

- 랜덤결과에 따라 전진, 머무르는 기능 MoveOrNot
- Race: Trynum 만큼 Race진행
- getPosition: 현재 Position
- winNum: 이긴횟수 기록

Game 구현

- 생성자구현: 차세팅, play 진행
  -play: 횟수 만큼 경주게임 시작
  -round: 한 라운드 게임진행
  -setCars: Input으로 받아온 이름으로 Car객체배열생성
  -sortCars: 매라운드 postion순으로 정렬

output 구현

- printRound: 라운드마다 게임결과 출력
