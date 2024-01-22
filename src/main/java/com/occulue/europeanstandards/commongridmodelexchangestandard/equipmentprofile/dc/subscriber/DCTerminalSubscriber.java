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
 * Subscriber for DCTerminal related events. .
 *
 * @author your_name_here
 */
@Component("dCTerminal-subscriber")
public class DCTerminalSubscriber extends BaseSubscriber {

  public DCTerminalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCTerminal>, DCTerminal> dCTerminalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCTerminalQuery(),
        ResponseTypes.multipleInstancesOf(DCTerminal.class),
        ResponseTypes.instanceOf(DCTerminal.class));
  }

  public SubscriptionQueryResult<DCTerminal, DCTerminal> dCTerminalSubscribe(
      @DestinationVariable UUID dCTerminalId) {
    return queryGateway.subscriptionQuery(
        new FindDCTerminalQuery(new LoadDCTerminalFilter(dCTerminalId)),
        ResponseTypes.instanceOf(DCTerminal.class),
        ResponseTypes.instanceOf(DCTerminal.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
