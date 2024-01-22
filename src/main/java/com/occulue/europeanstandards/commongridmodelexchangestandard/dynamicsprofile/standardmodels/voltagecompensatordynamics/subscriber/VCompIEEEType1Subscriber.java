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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.subscriber;

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
 * Subscriber for VCompIEEEType1 related events. .
 *
 * @author your_name_here
 */
@Component("vCompIEEEType1-subscriber")
public class VCompIEEEType1Subscriber extends BaseSubscriber {

  public VCompIEEEType1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VCompIEEEType1>, VCompIEEEType1> vCompIEEEType1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVCompIEEEType1Query(),
        ResponseTypes.multipleInstancesOf(VCompIEEEType1.class),
        ResponseTypes.instanceOf(VCompIEEEType1.class));
  }

  public SubscriptionQueryResult<VCompIEEEType1, VCompIEEEType1> vCompIEEEType1Subscribe(
      @DestinationVariable UUID vCompIEEEType1Id) {
    return queryGateway.subscriptionQuery(
        new FindVCompIEEEType1Query(new LoadVCompIEEEType1Filter(vCompIEEEType1Id)),
        ResponseTypes.instanceOf(VCompIEEEType1.class),
        ResponseTypes.instanceOf(VCompIEEEType1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
