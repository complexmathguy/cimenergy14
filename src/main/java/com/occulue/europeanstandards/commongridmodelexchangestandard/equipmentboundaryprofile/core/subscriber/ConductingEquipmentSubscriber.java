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
 * Subscriber for ConductingEquipment related events. .
 *
 * @author your_name_here
 */
@Component("conductingEquipment-subscriber")
public class ConductingEquipmentSubscriber extends BaseSubscriber {

  public ConductingEquipmentSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ConductingEquipment>, ConductingEquipment>
      conductingEquipmentSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllConductingEquipmentQuery(),
        ResponseTypes.multipleInstancesOf(ConductingEquipment.class),
        ResponseTypes.instanceOf(ConductingEquipment.class));
  }

  public SubscriptionQueryResult<ConductingEquipment, ConductingEquipment>
      conductingEquipmentSubscribe(@DestinationVariable UUID conductingEquipmentId) {
    return queryGateway.subscriptionQuery(
        new FindConductingEquipmentQuery(new LoadConductingEquipmentFilter(conductingEquipmentId)),
        ResponseTypes.instanceOf(ConductingEquipment.class),
        ResponseTypes.instanceOf(ConductingEquipment.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
