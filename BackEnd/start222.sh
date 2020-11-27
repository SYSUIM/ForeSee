#!/bin/sh
export EUREKA=./eurekaServer-222/target/eurekaServer-222-1.0-SNAPSHOT.jar
export GATEWAY=./gateway-222/target/gateway-222-1.0-SNAPSHOT.jar
export CONSUMER=./client-222/target/client-222-1.0-SNAPSHOT.jar
export EUREKA_port=8888
export GATEWAY_port=6666
export CONSUMER_port=8288
export EUREKA_log=./logs/eurekaServer.log
export GATEWAY_log=./logs/gateway.log
export CONSUMER_log=./logs/consumer.log


case "$1" in

start)
        ## 启动eureka
        echo "--------eureka Server开始启动--------------"
        nohup java -jar $EUREKA > $EUREKA_log 2>&1 &
        EUREKA_pid=`lsof -i:$EUREKA_port|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$EUREKA_pid" ]
            do
              EUREKA_pid=`lsof -i:$EUREKA_port|grep "LISTEN"|awk '{print $2}'`
            done
        echo "EUREKA SERVER pid is $EUREKA_pid"
        sleep 10
        echo "--------eureka Server启动成功--------------"

         ## 启动路由网关
        echo "--------开始启动Gateway---------------"
        nohup java -jar $GATEWAY > $GATEWAY_log 2>&1 &
        GATEWAY_pid=`lsof -i:$GATEWAY_port|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$GATEWAY_pid" ]
            do
              GATEWAY_pid=`lsof -i:$GATEWAY_port|grep "LISTEN"|awk '{print $2}'`
            done
        echo "Gateway pid is $GATEWAY_pid"
        echo "---------Gateway启动成功-----------"


        # 启动客户端
        echo "--------开始启动CONSUMER---------------"
        nohup java -jar $CONSUMER > $CONSUMER_log 2>&1 &
        CONSUMER_pid=`lsof -i:$CONSUMER_port|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$CONSUMER_pid" ]
            do
              CONSUMER_pid=`lsof -i:$CONSUMER_port|grep "LISTEN"|awk '{print $2}'`
            done
        echo "CONSUMER pid is $CONSUMER_pid"
        echo "---------CONSUMER 启动成功-----------"

        echo "=====start success=====";;



stop)

         P_ID=`ps -ef | grep -w $EUREKA | grep -v "grep" | awk '{print $2}'`
                if [ "$P_ID" == "" ]; then
                    echo "Eureka Server process not exists or stop success"
                else
                    kill -9 $P_ID
                    echo "Eureka Server killed success"
                fi

         P_ID=`ps -ef | grep -w $GATEWAY | grep -v "grep" | awk '{print $2}'`
                 if [ "$P_ID" == "" ]; then
                     echo "Gateway process not exists or stop success"
                 else
                     kill -9 $P_ID
                     echo "Gateway killed success"
                 fi

         P_ID=`ps -ef | grep -w $CONSUMER | grep -v "grep" | awk '{print $2}'`
                 if [ "$P_ID" = "" ]; then
                     echo "CONSUMER process not exists or stop success"
                 else
                     kill -9 $P_ID
                     echo "CONSUMER killed success"
                 fi

         echo "=====stop success=====";;

restart)
        $0 stop
        sleep 10
        $0 start
        echo "===restart success==="
        ;;
esac
exit 0
