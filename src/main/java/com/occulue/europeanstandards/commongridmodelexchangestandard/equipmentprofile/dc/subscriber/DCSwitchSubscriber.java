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
 * Subscriber for DCSwitch related events. .
 *
 * @author your_name_here
 */
@Component("dCSwitch-subscriber")
public class DCSwitchSubscriber extends BaseSubscriber {

  public DCSwitchSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCSwitch>, DCSwitch> dCSwitchSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCSwitchQuery(),
        ResponseTypes.multipleInstancesOf(DCSwitch.class),
        ResponseTypes.instanceOf(DCSwitch.class));
  }

  public SubscriptionQueryResult<DCSwitch, DCSwitch> dCSwitchSubscribe(
      @DestinationVariable UUID dCSwitchId) {
    return queryGateway.subscriptionQuery(
        new FindDCSwitchQuery(new LoadDCSwitchFilter(dCSwitchId)),
        ResponseTypes.instanceOf(DCSwitch.class),
        ResponseTypes.instanceOf(DCSwitch.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
