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
 * Subscriber for DCBaseTerminal related events. .
 *
 * @author your_name_here
 */
@Component("dCBaseTerminal-subscriber")
public class DCBaseTerminalSubscriber extends BaseSubscriber {

  public DCBaseTerminalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCBaseTerminal>, DCBaseTerminal> dCBaseTerminalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCBaseTerminalQuery(),
        ResponseTypes.multipleInstancesOf(DCBaseTerminal.class),
        ResponseTypes.instanceOf(DCBaseTerminal.class));
  }

  public SubscriptionQueryResult<DCBaseTerminal, DCBaseTerminal> dCBaseTerminalSubscribe(
      @DestinationVariable UUID dCBaseTerminalId) {
    return queryGateway.subscriptionQuery(
        new FindDCBaseTerminalQuery(new LoadDCBaseTerminalFilter(dCBaseTerminalId)),
        ResponseTypes.instanceOf(DCBaseTerminal.class),
        ResponseTypes.instanceOf(DCBaseTerminal.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
