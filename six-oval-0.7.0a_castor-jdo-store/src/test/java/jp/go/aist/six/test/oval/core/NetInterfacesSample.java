package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.sc.NetInterface;



public class NetInterfacesSample
{

    public static final NetInterface[]  NET_INTERFACES_1 =
        new NetInterface[] {
        new NetInterface( "Realtek RTL8168C(P)/8111C(P) Family PCI-E GBE NIC - \u30d1\u30b1\u30c3\u30c8 \u30b9\u30b1\u30b8\u30e5\u30fc\u30e9 \u30df\u30cb\u30dd\u30fc\u30c8",
                        "150.168.1.100",
                        "00-AA-BB-CC-11-22"
        ),
        new NetInterface( "VMware Virtual Ethernet Adapter for VMnet1",
                        "192.168.153.1",
                        "00-50-56-C0-00-01"
        ),
        new NetInterface( "VMware Virtual Ethernet Adapter for VMnet8",
                        "192.168.1.1",
                        "00-50-56-C0-00-08"
        )
    };

}
