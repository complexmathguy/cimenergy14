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
 * Subscriber for Equipment related events. .
 *
 * @author your_name_here
 */
@Component("equipment-subscriber")
public class EquipmentSubscriber extends BaseSubscriber {

  public EquipmentSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Equipment>, Equipment> equipmentSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquipmentQuery(),
        ResponseTypes.multipleInstancesOf(Equipment.class),
        ResponseTypes.instanceOf(Equipment.class));
  }

  public SubscriptionQueryResult<Equipment, Equipment> equipmentSubscribe(
      @DestinationVariable UUID equipmentId) {
    return queryGateway.subscriptionQuery(
        new FindEquipmentQuery(new LoadEquipmentFilter(equipmentId)),
        ResponseTypes.instanceOf(Equipment.class),
        ResponseTypes.instanceOf(Equipment.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
