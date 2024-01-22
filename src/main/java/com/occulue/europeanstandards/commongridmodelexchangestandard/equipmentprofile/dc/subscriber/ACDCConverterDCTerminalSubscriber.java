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
 * Subscriber for ACDCConverterDCTerminal related events. .
 *
 * @author your_name_here
 */
@Component("aCDCConverterDCTerminal-subscriber")
public class ACDCConverterDCTerminalSubscriber extends BaseSubscriber {

  public ACDCConverterDCTerminalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ACDCConverterDCTerminal>, ACDCConverterDCTerminal>
      aCDCConverterDCTerminalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllACDCConverterDCTerminalQuery(),
        ResponseTypes.multipleInstancesOf(ACDCConverterDCTerminal.class),
        ResponseTypes.instanceOf(ACDCConverterDCTerminal.class));
  }

  public SubscriptionQueryResult<ACDCConverterDCTerminal, ACDCConverterDCTerminal>
      aCDCConverterDCTerminalSubscribe(@DestinationVariable UUID aCDCConverterDCTerminalId) {
    return queryGateway.subscriptionQuery(
        new FindACDCConverterDCTerminalQuery(
            new LoadACDCConverterDCTerminalFilter(aCDCConverterDCTerminalId)),
        ResponseTypes.instanceOf(ACDCConverterDCTerminal.class),
        ResponseTypes.instanceOf(ACDCConverterDCTerminal.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
