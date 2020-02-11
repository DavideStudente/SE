#SOAP WSDL

##Server

New project > Maven > Java application


##Client

After Server started and running, create using always

New project > Maven > Java application

Specify in pom.xml wsdl location if not using activemq

using <wsdlUrls> <wsdlUrl> http://localhost:9000/bank?wsdl </wsdlUrl></wsdlUrls>


#REST

##Server 
Sempre new project > maven > java application
ovviamente pom diverso

##Client
New Project > Java > Java application

Click dx su project > add other... 
Dalla finestra selezionare
Web services > New Restful Java Client

Progetto (tasto dx) New -> Restful Java Client
Inserire nomee package
Select Rest Resource, selezionare "From Project", browse nel server



#Port already in use
Use fuser linux utility:
$ fuser 9000/tcp -k 
