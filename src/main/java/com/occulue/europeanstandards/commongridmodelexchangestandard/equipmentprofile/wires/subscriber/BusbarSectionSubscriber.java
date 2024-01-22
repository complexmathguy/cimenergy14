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
 * Subscriber for BusbarSection related events. .
 *
 * @author your_name_here
 */
@Component("busbarSection-subscriber")
public class BusbarSectionSubscriber extends BaseSubscriber {

  public BusbarSectionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<BusbarSection>, BusbarSection> busbarSectionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllBusbarSectionQuery(),
        ResponseTypes.multipleInstancesOf(BusbarSection.class),
        ResponseTypes.instanceOf(BusbarSection.class));
  }

  public SubscriptionQueryResult<BusbarSection, BusbarSection> busbarSectionSubscribe(
      @DestinationVariable UUID busbarSectionId) {
    return queryGateway.subscriptionQuery(
        new FindBusbarSectionQuery(new LoadBusbarSectionFilter(busbarSectionId)),
        ResponseTypes.instanceOf(BusbarSection.class),
        ResponseTypes.instanceOf(BusbarSection.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
