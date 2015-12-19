package com.ryan.wangbw.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MessengerService extends Service {

    static final int MSG_SAY_HELLO = 1;

    public MessengerService() {
    }

    class IncomingHandler extends Handler {

        private WeakReference<Service> mWeakReference;

        public IncomingHandler(Service service) {
            mWeakReference = new WeakReference<>(service);
        }

        @Override
        public void handleMessage(Message msg) {
            final Service service = mWeakReference.get();
            if (service!=null) {
                switch (msg.what) {
                    case MSG_SAY_HELLO:
                        Toast.makeText(MessengerService.this, "hello!", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        super.handleMessage(msg);
                }
            }
        }
    }

    final Messenger mMessenger = new Messenger(new IncomingHandler(MessengerService.this));


    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MessengerService.this, "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }
}
