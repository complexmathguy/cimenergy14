/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for Connector related events. .
 *
 * @author your_name_here
 */
@Component("connector-subscriber")
public class ConnectorSubscriber extends BaseSubscriber {

  public ConnectorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Connector>, Connector> connectorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllConnectorQuery(),
        ResponseTypes.multipleInstancesOf(Connector.class),
        ResponseTypes.instanceOf(Connector.class));
  }

  public SubscriptionQueryResult<Connector, Connector> connectorSubscribe(
      @DestinationVariable UUID connectorId) {
    return queryGateway.subscriptionQuery(
        new FindConnectorQuery(new LoadConnectorFilter(connectorId)),
        ResponseTypes.instanceOf(Connector.class),
        ResponseTypes.instanceOf(Connector.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
