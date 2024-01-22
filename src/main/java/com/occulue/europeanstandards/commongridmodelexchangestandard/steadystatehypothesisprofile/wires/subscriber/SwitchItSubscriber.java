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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires.subscriber;

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
 * Subscriber for SwitchIt related events. .
 *
 * @author your_name_here
 */
@Component("switchIt-subscriber")
public class SwitchItSubscriber extends BaseSubscriber {

  public SwitchItSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SwitchIt>, SwitchIt> switchItSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSwitchItQuery(),
        ResponseTypes.multipleInstancesOf(SwitchIt.class),
        ResponseTypes.instanceOf(SwitchIt.class));
  }

  public SubscriptionQueryResult<SwitchIt, SwitchIt> switchItSubscribe(
      @DestinationVariable UUID switchItId) {
    return queryGateway.subscriptionQuery(
        new FindSwitchItQuery(new LoadSwitchItFilter(switchItId)),
        ResponseTypes.instanceOf(SwitchIt.class),
        ResponseTypes.instanceOf(SwitchIt.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
