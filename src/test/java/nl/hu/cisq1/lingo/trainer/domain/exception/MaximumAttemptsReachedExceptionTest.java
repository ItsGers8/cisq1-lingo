package nl.hu.cisq1.lingo.trainer.domain.exception;

import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.trainer.domain.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaximumAttemptsReachedExceptionTest {
    @Test
    @DisplayName("exception should be thrown when guessing is tried after reaching 5 guesses")
    void exceptionTest() {
        Round round = new Round("woord", State.IN_PROGRESS, 5, new ArrayList<>());
        assertThrows(MaximumAttemptsReachedException.class, () -> round.guess("woord"));
    }
}