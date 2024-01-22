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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.subscriber;

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
 * Subscriber for EquivalentEquipment related events. .
 *
 * @author your_name_here
 */
@Component("equivalentEquipment-subscriber")
public class EquivalentEquipmentSubscriber extends BaseSubscriber {

  public EquivalentEquipmentSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EquivalentEquipment>, EquivalentEquipment>
      equivalentEquipmentSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquivalentEquipmentQuery(),
        ResponseTypes.multipleInstancesOf(EquivalentEquipment.class),
        ResponseTypes.instanceOf(EquivalentEquipment.class));
  }

  public SubscriptionQueryResult<EquivalentEquipment, EquivalentEquipment>
      equivalentEquipmentSubscribe(@DestinationVariable UUID equivalentEquipmentId) {
    return queryGateway.subscriptionQuery(
        new FindEquivalentEquipmentQuery(new LoadEquivalentEquipmentFilter(equivalentEquipmentId)),
        ResponseTypes.instanceOf(EquivalentEquipment.class),
        ResponseTypes.instanceOf(EquivalentEquipment.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
