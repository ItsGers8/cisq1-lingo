package nl.hu.cisq1.lingo.trainer.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.trainer.domain.State;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RoundDTO {
    public State state;
    public int attempts;
    public List<HintDTO> hints = new ArrayList<>();
    public List<FeedbackDTO> feedback = new ArrayList<>();

    public RoundDTO(Round round) {
        this.state = round.getState();
        this.attempts = round.getAttempts();
        round.getAllFeedback().forEach(feedback -> this.feedback.add(new FeedbackDTO(feedback)));
        round.getAllHints().forEach(hint -> this.hints.add(new HintDTO(hint)));
    }
}
