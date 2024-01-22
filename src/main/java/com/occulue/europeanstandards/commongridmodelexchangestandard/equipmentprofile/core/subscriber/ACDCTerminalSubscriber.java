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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for ACDCTerminal related events. .
 *
 * @author your_name_here
 */
@Component("aCDCTerminal-subscriber")
public class ACDCTerminalSubscriber extends BaseSubscriber {

  public ACDCTerminalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ACDCTerminal>, ACDCTerminal> aCDCTerminalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllACDCTerminalQuery(),
        ResponseTypes.multipleInstancesOf(ACDCTerminal.class),
        ResponseTypes.instanceOf(ACDCTerminal.class));
  }

  public SubscriptionQueryResult<ACDCTerminal, ACDCTerminal> aCDCTerminalSubscribe(
      @DestinationVariable UUID aCDCTerminalId) {
    return queryGateway.subscriptionQuery(
        new FindACDCTerminalQuery(new LoadACDCTerminalFilter(aCDCTerminalId)),
        ResponseTypes.instanceOf(ACDCTerminal.class),
        ResponseTypes.instanceOf(ACDCTerminal.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
