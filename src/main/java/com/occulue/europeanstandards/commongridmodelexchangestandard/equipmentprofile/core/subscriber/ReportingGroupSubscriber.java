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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for ReportingGroup related events. .
 *
 * @author your_name_here
 */
@Component("reportingGroup-subscriber")
public class ReportingGroupSubscriber extends BaseSubscriber {

  public ReportingGroupSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ReportingGroup>, ReportingGroup> reportingGroupSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllReportingGroupQuery(),
        ResponseTypes.multipleInstancesOf(ReportingGroup.class),
        ResponseTypes.instanceOf(ReportingGroup.class));
  }

  public SubscriptionQueryResult<ReportingGroup, ReportingGroup> reportingGroupSubscribe(
      @DestinationVariable UUID reportingGroupId) {
    return queryGateway.subscriptionQuery(
        new FindReportingGroupQuery(new LoadReportingGroupFilter(reportingGroupId)),
        ResponseTypes.instanceOf(ReportingGroup.class),
        ResponseTypes.instanceOf(ReportingGroup.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
