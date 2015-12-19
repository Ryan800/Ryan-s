package com.ryan.wangbw.rxjava;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * author: wangbw
 * Date: 2015-11-30
 * Time: 09:26
 * Desc:
 */
public class RxJava {

    public static void main(String[] args) {
        RxJava rxJava = new RxJava();
//        rxJava.test();
//        rxJava.test2();
//        rxJava.test3();
//        rxJava.test4();
//        rxJava.test6();
//        rxJava.test7();
        rxJava.test8();
    }

    private void test() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello, world!");
//                        subscriber.onCompleted();
//                        subscriber.onError(new Throwable("error"));
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:"+s);
            }
        };

        myObservable.subscribe(mySubscriber);
    }

    public void test2() {
//        Observable observable = Observable.just("Hello world!");
//        Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        };
//
//        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                System.out.println("onErrorAction");
//            }
//        };
//
//        Action0 onCompleteAction = new Action0() {
//            @Override
//            public void call() {
//                System.out.println("onCompleteAction");
//            }
//        };
//        observable.subscribe(onNextAction, onErrorAction, onCompleteAction);

        //简化
        Observable.just("Hello World!", "ooh")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("call:" + s);
                    }
                });
    }

    //操作符map 转换事件
    public void test3() {
        Observable.just("Hello, World!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -Dan";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    //map操作符进阶 just
    public void test4() {
        Observable.just("Hello, world!")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return Integer.toString(integer);
                    }
                })
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("doOnNext:" + s);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String string) {
                        System.out.println(string);
                    }
                });
    }

    public void test5() {
        query("Hello world")
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> strings) {

                    }
                });
    }

    public Observable<List<String>> query(String text) {
        return Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
//                subscriber.onNext();
            }
        });
    }

    public void test6() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:"+s);
            }
        };

        observable.subscribe(subscriber);
    }

    //from
    private void test7() {
        String[] names = new String[]{"wang", "bing", "wen"};
        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    //scheduler
    private void test8() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("number:" + integer);
                    }
                });
    }
}
