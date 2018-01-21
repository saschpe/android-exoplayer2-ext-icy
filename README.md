# ExoPlayer2 Shoutcast Metadata Protocol (ICY) extension
[![Download](https://api.bintray.com/packages/saschpe/maven/android-android-exoplayer2-ext-icy/images/download.svg)](https://bintray.com/saschpe/maven/android-android-exoplayer2-ext-icy/_latestVersion)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/saschpe/android-android-exoplayer2-ext-icy.svg?branch=master)](https://travis-ci.org/saschpe/android-android-exoplayer2-ext-icy)
<a href="http://www.methodscount.com/?lib=saschpe.android%3Aandroid-exoplayer2-ext-icy%3A1.1.1"><img src="https://img.shields.io/badge/Methods and size-core: 100 | deps: 19640 | 25 KB-e91e63.svg"/></a>

The Shoutcast Metadata Protocol extension provides **IcyHttpDataSource** and 
**IcyHttpDataSourceFactory** which can parse ICY metadata information such as stream name and
genre as well as current song information from a music stream.

You can find the protocol description here:

- https://cast.readme.io/v1.0/docs/icy
- http://www.smackfu.com/stuff/programming/shoutcast.html


# Usage
To receive information about the current music stream (such as name and genre, see **IcyHeaders**
 class) as well as current song information (see **IcyMetadata** class), pass an instance of
 **IcyHttpDataSourceFactory** instead of an **DefaultHttpDataSourceFactory** like this (in Kotlin):

```kotlin
// ... exoPlayer instance already created ...

// Custom HTTP data source factory which requests Icy metadata and parses it if
// the stream server supports it
val icyHttpDataSourceFactory = IcyHttpDataSourceFactory.Builder(userAgent)
    .setIcyHeadersListener { icyHeaders ->
        Log.d("XXX", "onIcyHeaders: %s".format(icyHeaders.toString()))
    }
    .setIcyMetadataChangeListener { icyMetadata ->
        Log.d("XXX", "onIcyMetaData: %s".format(icyMetadata.toString()))
    }
    .build()

// Produces DataSource instances through which media data is loaded
val dataSourceFactory = DefaultDataSourceFactory(applicationContext, null, icyHttpDataSourceFactory)
// Produces Extractor instances for parsing the media data
val extractorsFactory = DefaultExtractorsFactory()

// The MediaSource represents the media to be played
val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
    .setExtractorsFactory(extractorsFactory)
    .createMediaSource(sourceUri)

// Prepares media to play (happens on background thread) and triggers
// {@code onPlayerStateChanged} callback when the stream is ready to play
exoPlayer?.prepare(mediaSource)
```

# Download
```groovy
compile 'saschpe.android.exoplayer2:ext-icy:1.0.0'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].


# License

    Copyright 2018 Sascha Peilicke

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
