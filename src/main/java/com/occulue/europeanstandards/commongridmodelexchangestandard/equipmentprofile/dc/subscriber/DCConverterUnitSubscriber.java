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
 * Subscriber for DCConverterUnit related events. .
 *
 * @author your_name_here
 */
@Component("dCConverterUnit-subscriber")
public class DCConverterUnitSubscriber extends BaseSubscriber {

  public DCConverterUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCConverterUnit>, DCConverterUnit>
      dCConverterUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCConverterUnitQuery(),
        ResponseTypes.multipleInstancesOf(DCConverterUnit.class),
        ResponseTypes.instanceOf(DCConverterUnit.class));
  }

  public SubscriptionQueryResult<DCConverterUnit, DCConverterUnit> dCConverterUnitSubscribe(
      @DestinationVariable UUID dCConverterUnitId) {
    return queryGateway.subscriptionQuery(
        new FindDCConverterUnitQuery(new LoadDCConverterUnitFilter(dCConverterUnitId)),
        ResponseTypes.instanceOf(DCConverterUnit.class),
        ResponseTypes.instanceOf(DCConverterUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
