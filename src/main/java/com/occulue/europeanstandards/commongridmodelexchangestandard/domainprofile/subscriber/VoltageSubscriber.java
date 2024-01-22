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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for Voltage related events. .
 *
 * @author your_name_here
 */
@Component("voltage-subscriber")
public class VoltageSubscriber extends BaseSubscriber {

  public VoltageSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Voltage>, Voltage> voltageSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVoltageQuery(),
        ResponseTypes.multipleInstancesOf(Voltage.class),
        ResponseTypes.instanceOf(Voltage.class));
  }

  public SubscriptionQueryResult<Voltage, Voltage> voltageSubscribe(
      @DestinationVariable UUID voltageId) {
    return queryGateway.subscriptionQuery(
        new FindVoltageQuery(new LoadVoltageFilter(voltageId)),
        ResponseTypes.instanceOf(Voltage.class),
        ResponseTypes.instanceOf(Voltage.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
