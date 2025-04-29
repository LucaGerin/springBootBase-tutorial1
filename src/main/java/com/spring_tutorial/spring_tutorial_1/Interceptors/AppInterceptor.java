package com.spring_tutorial.spring_tutorial_1.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
Tre metodi dell'interfaccia HandlerInterceptor da sovrascrivere:
- preHandle: utilizzato per effettuare operazioni prima che la richiesta venga inoltrata al Controller.
- postHandle: utilizzato per effettuare operazioni dopo che la richiesta è stata gestita, ma prima che la risposta venga inviata al client.
- afterCompletion: utilizzato per effettuare operazioni dopo che la risposta è stata inviata al client.
Inoltre è necessario registrare l'interceptor creato in una classe di configurazione che implementa l'interfaccia WebMvcConfigurer.
 */
@Component
public class AppInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Ciao, sono il preHandle");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Ciao, sono il postHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Ciao, sono l'afterCompletion");
    }
}
