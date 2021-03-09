package step3.module;

import step3.domain.CarManager;
import step3.domain.RacingResult;
import step3.ui.dto.RequestRacingGame;

import java.util.stream.IntStream;

import static step3.util.Constants.START_IDX;

/**
 * 레이싱 게임 역할을 하는 클래스
 */
public class CarRacingGame {

    // 자동차 게임이 실행되기 위한 필수 필드
    private CarManager carManager;
    private int attemptCount;
    private final RacingResult racingResult;

    public CarRacingGame(RequestRacingGame userInput) {
        initGame(userInput);
        racingResult = new RacingResult();
    }

    private void initGame(RequestRacingGame userInput) {
        attemptCount = userInput.getAttemptCount();
        carManager = new CarManager(userInput.getParticipants());
    }

    // 레이스
    public void race() {
        IntStream.range(START_IDX, attemptCount)
                .forEach(value ->
                        // 라운드 별 기록 저장
//                        racingRounds.add(carManager.run())
                        racingResult.addRacingRound(carManager.run())
                );
    }

    public RacingResult getRacingResult() {
        return racingResult;
    }
}
