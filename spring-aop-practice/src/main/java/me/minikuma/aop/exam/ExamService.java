package me.minikuma.aop.exam;

import lombok.RequiredArgsConstructor;
import me.minikuma.aop.exam.annotation.Trace;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    @Trace
    public void request(String itemId) {
        examRepository.save(itemId);
    }
}
