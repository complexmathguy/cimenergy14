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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.subscriber;

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
 * Subscriber for EquipmentVersion related events. .
 *
 * @author your_name_here
 */
@Component("equipmentVersion-subscriber")
public class EquipmentVersionSubscriber extends BaseSubscriber {

  public EquipmentVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EquipmentVersion>, EquipmentVersion>
      equipmentVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquipmentVersionQuery(),
        ResponseTypes.multipleInstancesOf(EquipmentVersion.class),
        ResponseTypes.instanceOf(EquipmentVersion.class));
  }

  public SubscriptionQueryResult<EquipmentVersion, EquipmentVersion> equipmentVersionSubscribe(
      @DestinationVariable UUID equipmentVersionId) {
    return queryGateway.subscriptionQuery(
        new FindEquipmentVersionQuery(new LoadEquipmentVersionFilter(equipmentVersionId)),
        ResponseTypes.instanceOf(EquipmentVersion.class),
        ResponseTypes.instanceOf(EquipmentVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
