(define (println . args) (if (null? args) (newline) (begin (display (car args)) (apply println (cdr args)))))

(define (readlines filename)
    (call-with-input-file filename
        (lambda (p)
            (let loop ((line (read-line p))
                (result '()))
            (if (eof-object? line)
                (reverse result)
                (loop (read-line p) (cons line result)))))))