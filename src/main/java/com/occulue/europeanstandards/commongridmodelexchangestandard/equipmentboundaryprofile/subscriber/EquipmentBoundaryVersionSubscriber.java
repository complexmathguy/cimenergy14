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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.subscriber;

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
 * Subscriber for EquipmentBoundaryVersion related events. .
 *
 * @author your_name_here
 */
@Component("equipmentBoundaryVersion-subscriber")
public class EquipmentBoundaryVersionSubscriber extends BaseSubscriber {

  public EquipmentBoundaryVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EquipmentBoundaryVersion>, EquipmentBoundaryVersion>
      equipmentBoundaryVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquipmentBoundaryVersionQuery(),
        ResponseTypes.multipleInstancesOf(EquipmentBoundaryVersion.class),
        ResponseTypes.instanceOf(EquipmentBoundaryVersion.class));
  }

  public SubscriptionQueryResult<EquipmentBoundaryVersion, EquipmentBoundaryVersion>
      equipmentBoundaryVersionSubscribe(@DestinationVariable UUID equipmentBoundaryVersionId) {
    return queryGateway.subscriptionQuery(
        new FindEquipmentBoundaryVersionQuery(
            new LoadEquipmentBoundaryVersionFilter(equipmentBoundaryVersionId)),
        ResponseTypes.instanceOf(EquipmentBoundaryVersion.class),
        ResponseTypes.instanceOf(EquipmentBoundaryVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
