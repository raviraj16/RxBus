package br.com.tap4mobile.radio.utility;

import org.reactivestreams.Subscription;

import br.com.tap4mobile.radio.listener.GetDefaultResponseCallback;
import br.com.tap4mobile.radio.model.login.LoginResponseModel;
import br.com.tap4mobile.radio.network.DisposableObserverImpl;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Ravi Raj Priyadarshi on 11-08-2017.
 */

public class RxEventBusSticky {

    private static BehaviorSubject<Object> sSubject = BehaviorSubject.create();

    private RxEventBusSticky() {
        // hidden constructor
    }

    public static Disposable subscribeWith(GetDefaultResponseCallback callback) {
        return sSubject.subscribeWith(new DisposableObserverImpl<>(callback));
    }

    public static void publish(@NonNull Object message) {
        sSubject.onNext(message);
    }
}
