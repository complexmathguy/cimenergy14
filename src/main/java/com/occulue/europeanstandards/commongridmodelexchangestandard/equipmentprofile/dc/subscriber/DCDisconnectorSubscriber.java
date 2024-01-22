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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

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
 * Subscriber for DCDisconnector related events. .
 *
 * @author your_name_here
 */
@Component("dCDisconnector-subscriber")
public class DCDisconnectorSubscriber extends BaseSubscriber {

  public DCDisconnectorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCDisconnector>, DCDisconnector> dCDisconnectorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCDisconnectorQuery(),
        ResponseTypes.multipleInstancesOf(DCDisconnector.class),
        ResponseTypes.instanceOf(DCDisconnector.class));
  }

  public SubscriptionQueryResult<DCDisconnector, DCDisconnector> dCDisconnectorSubscribe(
      @DestinationVariable UUID dCDisconnectorId) {
    return queryGateway.subscriptionQuery(
        new FindDCDisconnectorQuery(new LoadDCDisconnectorFilter(dCDisconnectorId)),
        ResponseTypes.instanceOf(DCDisconnector.class),
        ResponseTypes.instanceOf(DCDisconnector.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
