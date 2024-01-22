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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for EnergyConsumer related events. .
 *
 * @author your_name_here
 */
@Component("energyConsumer-subscriber")
public class EnergyConsumerSubscriber extends BaseSubscriber {

  public EnergyConsumerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EnergyConsumer>, EnergyConsumer> energyConsumerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEnergyConsumerQuery(),
        ResponseTypes.multipleInstancesOf(EnergyConsumer.class),
        ResponseTypes.instanceOf(EnergyConsumer.class));
  }

  public SubscriptionQueryResult<EnergyConsumer, EnergyConsumer> energyConsumerSubscribe(
      @DestinationVariable UUID energyConsumerId) {
    return queryGateway.subscriptionQuery(
        new FindEnergyConsumerQuery(new LoadEnergyConsumerFilter(energyConsumerId)),
        ResponseTypes.instanceOf(EnergyConsumer.class),
        ResponseTypes.instanceOf(EnergyConsumer.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
