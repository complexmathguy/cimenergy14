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
 * Subscriber for PerLengthDCLineParameter related events. .
 *
 * @author your_name_here
 */
@Component("perLengthDCLineParameter-subscriber")
public class PerLengthDCLineParameterSubscriber extends BaseSubscriber {

  public PerLengthDCLineParameterSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PerLengthDCLineParameter>, PerLengthDCLineParameter>
      perLengthDCLineParameterSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPerLengthDCLineParameterQuery(),
        ResponseTypes.multipleInstancesOf(PerLengthDCLineParameter.class),
        ResponseTypes.instanceOf(PerLengthDCLineParameter.class));
  }

  public SubscriptionQueryResult<PerLengthDCLineParameter, PerLengthDCLineParameter>
      perLengthDCLineParameterSubscribe(@DestinationVariable UUID perLengthDCLineParameterId) {
    return queryGateway.subscriptionQuery(
        new FindPerLengthDCLineParameterQuery(
            new LoadPerLengthDCLineParameterFilter(perLengthDCLineParameterId)),
        ResponseTypes.instanceOf(PerLengthDCLineParameter.class),
        ResponseTypes.instanceOf(PerLengthDCLineParameter.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
