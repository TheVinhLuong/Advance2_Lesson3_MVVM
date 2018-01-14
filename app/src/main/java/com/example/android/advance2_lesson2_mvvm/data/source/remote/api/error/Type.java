package com.example.android.advance2_lesson2_mvvm.data.source.remote.api.error;

import android.support.annotation.StringDef;

/**
 * Created by VinhTL on 18/10/2017.
 */

@StringDef({Type.NETWORK, Type.HTTP, Type.UNEXPECTED, Type.SERVER})
public @interface Type {

    /**
     * An {@link IOException} occurred while communicating to the server.
     */
    String NETWORK = "NETWORK";

    /**
     * A non-2xx HTTP status code was received from the server.
     */
    String HTTP = "HTTP";

    /**
     * A error server with code & message
     */
    String SERVER = "SERVER";

    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    String UNEXPECTED = "UNEXPECTED";
}
