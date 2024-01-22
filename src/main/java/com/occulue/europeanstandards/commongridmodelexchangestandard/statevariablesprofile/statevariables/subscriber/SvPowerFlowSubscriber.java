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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.subscriber;

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
 * Subscriber for SvPowerFlow related events. .
 *
 * @author your_name_here
 */
@Component("svPowerFlow-subscriber")
public class SvPowerFlowSubscriber extends BaseSubscriber {

  public SvPowerFlowSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SvPowerFlow>, SvPowerFlow> svPowerFlowSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSvPowerFlowQuery(),
        ResponseTypes.multipleInstancesOf(SvPowerFlow.class),
        ResponseTypes.instanceOf(SvPowerFlow.class));
  }

  public SubscriptionQueryResult<SvPowerFlow, SvPowerFlow> svPowerFlowSubscribe(
      @DestinationVariable UUID svPowerFlowId) {
    return queryGateway.subscriptionQuery(
        new FindSvPowerFlowQuery(new LoadSvPowerFlowFilter(svPowerFlowId)),
        ResponseTypes.instanceOf(SvPowerFlow.class),
        ResponseTypes.instanceOf(SvPowerFlow.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
