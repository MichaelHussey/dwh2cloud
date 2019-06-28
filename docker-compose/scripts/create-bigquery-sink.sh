#/bin/bash
if [ "$1" = "-d" ]
then
	URL=connectors/orders-sink-connector1
	METHOD=DELETE
	curl -i -X $METHOD \
	    -H "Accept:application/json" \
	    -H  "Content-Type:application/json" \
	    http://localhost:8083/$URL
else
if [ "$1" = "-v" ]
	then
		URL=connector-plugins/BigQuerySinkConnector/config/validate
		METHOD=PUT
		
		curl -i -X $METHOD \
		    -H "Accept:application/json" \
		    -H  "Content-Type:application/json" \
		    http://localhost:8083/$URL --data-binary "@$PWD/config/orders_file_source.properties"
	else
		URL=connectors/
		METHOD=POST
		
		curl -i -X $METHOD \
		    -H "Accept:application/json" \
		    -H  "Content-Type:application/json" \
		    http://localhost:8083/$URL --data-binary "@$PWD/config/orders_bigquery_sink.properties"
	fi
fi
	
