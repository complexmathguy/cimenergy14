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
 * Subscriber for DCSeriesDevice related events. .
 *
 * @author your_name_here
 */
@Component("dCSeriesDevice-subscriber")
public class DCSeriesDeviceSubscriber extends BaseSubscriber {

  public DCSeriesDeviceSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCSeriesDevice>, DCSeriesDevice> dCSeriesDeviceSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCSeriesDeviceQuery(),
        ResponseTypes.multipleInstancesOf(DCSeriesDevice.class),
        ResponseTypes.instanceOf(DCSeriesDevice.class));
  }

  public SubscriptionQueryResult<DCSeriesDevice, DCSeriesDevice> dCSeriesDeviceSubscribe(
      @DestinationVariable UUID dCSeriesDeviceId) {
    return queryGateway.subscriptionQuery(
        new FindDCSeriesDeviceQuery(new LoadDCSeriesDeviceFilter(dCSeriesDeviceId)),
        ResponseTypes.instanceOf(DCSeriesDevice.class),
        ResponseTypes.instanceOf(DCSeriesDevice.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
