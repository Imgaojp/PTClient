<?xml version="1.0" encoding="utf-8"?>
<rss version="2.0">
    <channel>
        <title>PTClient</title>
        <link>
        <![CDATA[https://ptclient.cn]]></link>
        <description><![CDATA[Latest torrents from PTClient - ]]></description>
        <language>zh-cn</language>
        <copyright>Copyright (c) PTClient 2018, all rights reserved</copyright>
        <managingEditor>imgaojp@gmail.com</managingEditor>
        <webMaster>imgaojp@gmail.com</webMaster>
        <pubDate>${date}</pubDate>
        <generator>PTClient RSS Generator</generator>
        <docs><![CDATA[http://www.rssboard.org/rss-specification]]></docs>
        <ttl>60</ttl>
        <image>
            <url><![CDATA[https://ptclient.cn/rss_logo.jpg]]></url>
            <title>PTClient Torrents</title>
            <link>
            <![CDATA[https://ptclient.cn]]></link>
            <width>100</width>
            <height>100</height>
            <description>PTClient Torrents</description>
        </image>




        <#list rss as rssA>
        <item>
            <title><![CDATA[${rssA.title}
                ]]></title>
            <link>
                ${rssA.link}</link>
            <enclosure url="${rssA.url}" type="application/x-bittorrent"/>
            <pubDate>${rssA.date}</pubDate>
        </item>
        </#list>

    <#--<item>-->
    <#--<title><![CDATA[Ruyi's.Royal.Love.in.the.Palace.2018.V2.WEB-DL.1080p.H264.AAC-HDCTV-->
    <#--]]></title>-->
    <#--<link>-->
    <#--https://***.org/details.php?id=***</link>-->
    <#--<enclosure url="https://***.org/download.php?id=***&amp;passkey=*************"-->
    <#--length="2045132748" type="application/x-bittorrent"/>-->
    <#--<pubDate>${date}</pubDate>-->
    <#--</item>-->

    </channel>
</rss>