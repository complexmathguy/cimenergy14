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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.subscriber;

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
 * Subscriber for ThermalGeneratingUnit related events. .
 *
 * @author your_name_here
 */
@Component("thermalGeneratingUnit-subscriber")
public class ThermalGeneratingUnitSubscriber extends BaseSubscriber {

  public ThermalGeneratingUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ThermalGeneratingUnit>, ThermalGeneratingUnit>
      thermalGeneratingUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllThermalGeneratingUnitQuery(),
        ResponseTypes.multipleInstancesOf(ThermalGeneratingUnit.class),
        ResponseTypes.instanceOf(ThermalGeneratingUnit.class));
  }

  public SubscriptionQueryResult<ThermalGeneratingUnit, ThermalGeneratingUnit>
      thermalGeneratingUnitSubscribe(@DestinationVariable UUID thermalGeneratingUnitId) {
    return queryGateway.subscriptionQuery(
        new FindThermalGeneratingUnitQuery(
            new LoadThermalGeneratingUnitFilter(thermalGeneratingUnitId)),
        ResponseTypes.instanceOf(ThermalGeneratingUnit.class),
        ResponseTypes.instanceOf(ThermalGeneratingUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
