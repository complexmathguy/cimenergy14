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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

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
 * Subscriber for AccumulatorReset related events. .
 *
 * @author your_name_here
 */
@Component("accumulatorReset-subscriber")
public class AccumulatorResetSubscriber extends BaseSubscriber {

  public AccumulatorResetSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AccumulatorReset>, AccumulatorReset>
      accumulatorResetSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAccumulatorResetQuery(),
        ResponseTypes.multipleInstancesOf(AccumulatorReset.class),
        ResponseTypes.instanceOf(AccumulatorReset.class));
  }

  public SubscriptionQueryResult<AccumulatorReset, AccumulatorReset> accumulatorResetSubscribe(
      @DestinationVariable UUID accumulatorResetId) {
    return queryGateway.subscriptionQuery(
        new FindAccumulatorResetQuery(new LoadAccumulatorResetFilter(accumulatorResetId)),
        ResponseTypes.instanceOf(AccumulatorReset.class),
        ResponseTypes.instanceOf(AccumulatorReset.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
