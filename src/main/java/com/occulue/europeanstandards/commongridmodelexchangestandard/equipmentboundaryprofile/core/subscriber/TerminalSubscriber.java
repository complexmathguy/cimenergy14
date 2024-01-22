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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.subscriber;

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
 * Subscriber for Terminal related events. .
 *
 * @author your_name_here
 */
@Component("terminal-subscriber")
public class TerminalSubscriber extends BaseSubscriber {

  public TerminalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Terminal>, Terminal> terminalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTerminalQuery(),
        ResponseTypes.multipleInstancesOf(Terminal.class),
        ResponseTypes.instanceOf(Terminal.class));
  }

  public SubscriptionQueryResult<Terminal, Terminal> terminalSubscribe(
      @DestinationVariable UUID terminalId) {
    return queryGateway.subscriptionQuery(
        new FindTerminalQuery(new LoadTerminalFilter(terminalId)),
        ResponseTypes.instanceOf(Terminal.class),
        ResponseTypes.instanceOf(Terminal.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
