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
 * Subscriber for PowerSystemResource related events. .
 *
 * @author your_name_here
 */
@Component("powerSystemResource-subscriber")
public class PowerSystemResourceSubscriber extends BaseSubscriber {

  public PowerSystemResourceSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PowerSystemResource>, PowerSystemResource>
      powerSystemResourceSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPowerSystemResourceQuery(),
        ResponseTypes.multipleInstancesOf(PowerSystemResource.class),
        ResponseTypes.instanceOf(PowerSystemResource.class));
  }

  public SubscriptionQueryResult<PowerSystemResource, PowerSystemResource>
      powerSystemResourceSubscribe(@DestinationVariable UUID powerSystemResourceId) {
    return queryGateway.subscriptionQuery(
        new FindPowerSystemResourceQuery(new LoadPowerSystemResourceFilter(powerSystemResourceId)),
        ResponseTypes.instanceOf(PowerSystemResource.class),
        ResponseTypes.instanceOf(PowerSystemResource.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
