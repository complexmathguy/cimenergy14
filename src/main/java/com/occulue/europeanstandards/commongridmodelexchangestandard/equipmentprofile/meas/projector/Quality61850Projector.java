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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Quality61850 as outlined for the CQRS pattern. All event handling and query
 * handling related to Quality61850 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by Quality61850Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("quality61850")
@Component("quality61850-projector")
public class Quality61850Projector extends Quality61850EntityProjector {

  // core constructor
  public Quality61850Projector(
      Quality61850Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateQuality61850Event
   */
  @EventHandler(payloadType = CreateQuality61850Event.class)
  public void handle(CreateQuality61850Event event) {
    LOGGER.info("handling CreateQuality61850Event - " + event);
    Quality61850 entity = new Quality61850();
    entity.setQuality61850Id(event.getQuality61850Id());
    entity.setSource(event.getSource());
    entity.setValidity(event.getValidity());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UpdateQuality61850Event
   */
  @EventHandler(payloadType = UpdateQuality61850Event.class)
  public void handle(UpdateQuality61850Event event) {
    LOGGER.info("handling UpdateQuality61850Event - " + event);

    Quality61850 entity = new Quality61850();
    entity.setQuality61850Id(event.getQuality61850Id());
    entity.setBadReference(event.getBadReference());
    entity.setEstimatorReplaced(event.getEstimatorReplaced());
    entity.setFailure(event.getFailure());
    entity.setOldData(event.getOldData());
    entity.setOperatorBlocked(event.getOperatorBlocked());
    entity.setOscillatory(event.getOscillatory());
    entity.setOutOfRange(event.getOutOfRange());
    entity.setOverFlow(event.getOverFlow());
    entity.setSource(event.getSource());
    entity.setSuspect(event.getSuspect());
    entity.setTest(event.getTest());
    entity.setValidity(event.getValidity());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event DeleteQuality61850Event
   */
  @EventHandler(payloadType = DeleteQuality61850Event.class)
  public void handle(DeleteQuality61850Event event) {
    LOGGER.info("handling DeleteQuality61850Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Quality61850 entity = delete(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignBadReferenceToQuality61850Event
   */
  @EventHandler(payloadType = AssignBadReferenceToQuality61850Event.class)
  public void handle(AssignBadReferenceToQuality61850Event event) {
    LOGGER.info("handling AssignBadReferenceToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignBadReference(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignBadReferenceFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignBadReferenceFromQuality61850Event.class)
  public void handle(UnAssignBadReferenceFromQuality61850Event event) {
    LOGGER.info("handling UnAssignBadReferenceFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignBadReference(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignEstimatorReplacedToQuality61850Event
   */
  @EventHandler(payloadType = AssignEstimatorReplacedToQuality61850Event.class)
  public void handle(AssignEstimatorReplacedToQuality61850Event event) {
    LOGGER.info("handling AssignEstimatorReplacedToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignEstimatorReplaced(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignEstimatorReplacedFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignEstimatorReplacedFromQuality61850Event.class)
  public void handle(UnAssignEstimatorReplacedFromQuality61850Event event) {
    LOGGER.info("handling UnAssignEstimatorReplacedFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignEstimatorReplaced(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignFailureToQuality61850Event
   */
  @EventHandler(payloadType = AssignFailureToQuality61850Event.class)
  public void handle(AssignFailureToQuality61850Event event) {
    LOGGER.info("handling AssignFailureToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignFailure(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignFailureFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignFailureFromQuality61850Event.class)
  public void handle(UnAssignFailureFromQuality61850Event event) {
    LOGGER.info("handling UnAssignFailureFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignFailure(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignOldDataToQuality61850Event
   */
  @EventHandler(payloadType = AssignOldDataToQuality61850Event.class)
  public void handle(AssignOldDataToQuality61850Event event) {
    LOGGER.info("handling AssignOldDataToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignOldData(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignOldDataFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignOldDataFromQuality61850Event.class)
  public void handle(UnAssignOldDataFromQuality61850Event event) {
    LOGGER.info("handling UnAssignOldDataFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignOldData(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignOperatorBlockedToQuality61850Event
   */
  @EventHandler(payloadType = AssignOperatorBlockedToQuality61850Event.class)
  public void handle(AssignOperatorBlockedToQuality61850Event event) {
    LOGGER.info("handling AssignOperatorBlockedToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignOperatorBlocked(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignOperatorBlockedFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignOperatorBlockedFromQuality61850Event.class)
  public void handle(UnAssignOperatorBlockedFromQuality61850Event event) {
    LOGGER.info("handling UnAssignOperatorBlockedFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignOperatorBlocked(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignOscillatoryToQuality61850Event
   */
  @EventHandler(payloadType = AssignOscillatoryToQuality61850Event.class)
  public void handle(AssignOscillatoryToQuality61850Event event) {
    LOGGER.info("handling AssignOscillatoryToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignOscillatory(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignOscillatoryFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignOscillatoryFromQuality61850Event.class)
  public void handle(UnAssignOscillatoryFromQuality61850Event event) {
    LOGGER.info("handling UnAssignOscillatoryFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignOscillatory(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignOutOfRangeToQuality61850Event
   */
  @EventHandler(payloadType = AssignOutOfRangeToQuality61850Event.class)
  public void handle(AssignOutOfRangeToQuality61850Event event) {
    LOGGER.info("handling AssignOutOfRangeToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignOutOfRange(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignOutOfRangeFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignOutOfRangeFromQuality61850Event.class)
  public void handle(UnAssignOutOfRangeFromQuality61850Event event) {
    LOGGER.info("handling UnAssignOutOfRangeFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignOutOfRange(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignOverFlowToQuality61850Event
   */
  @EventHandler(payloadType = AssignOverFlowToQuality61850Event.class)
  public void handle(AssignOverFlowToQuality61850Event event) {
    LOGGER.info("handling AssignOverFlowToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignOverFlow(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignOverFlowFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignOverFlowFromQuality61850Event.class)
  public void handle(UnAssignOverFlowFromQuality61850Event event) {
    LOGGER.info("handling UnAssignOverFlowFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignOverFlow(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignSuspectToQuality61850Event
   */
  @EventHandler(payloadType = AssignSuspectToQuality61850Event.class)
  public void handle(AssignSuspectToQuality61850Event event) {
    LOGGER.info("handling AssignSuspectToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignSuspect(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignSuspectFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignSuspectFromQuality61850Event.class)
  public void handle(UnAssignSuspectFromQuality61850Event event) {
    LOGGER.info("handling UnAssignSuspectFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignSuspect(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event AssignTestToQuality61850Event
   */
  @EventHandler(payloadType = AssignTestToQuality61850Event.class)
  public void handle(AssignTestToQuality61850Event event) {
    LOGGER.info("handling AssignTestToQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Quality61850 entity = assignTest(event.getQuality61850Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /*
   * @param	event UnAssignTestFromQuality61850Event
   */
  @EventHandler(payloadType = UnAssignTestFromQuality61850Event.class)
  public void handle(UnAssignTestFromQuality61850Event event) {
    LOGGER.info("handling UnAssignTestFromQuality61850Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Quality61850 entity = unAssignTest(event.getQuality61850Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindQuality61850(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllQuality61850(entity);
  }

  /**
   * Method to retrieve the Quality61850 via an Quality61850PrimaryKey.
   *
   * @param id Long
   * @return Quality61850
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Quality61850 handle(FindQuality61850Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getQuality61850Id());
  }

  /**
   * Method to retrieve a collection of all Quality61850s
   *
   * @param query FindAllQuality61850Query
   * @return List<Quality61850>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Quality61850> handle(FindAllQuality61850Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindQuality61850, but only if the id matches
   *
   * @param entity Quality61850
   */
  protected void emitFindQuality61850(Quality61850 entity) {
    LOGGER.info("handling emitFindQuality61850");

    queryUpdateEmitter.emit(
        FindQuality61850Query.class,
        query -> query.getFilter().getQuality61850Id().equals(entity.getQuality61850Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllQuality61850
   *
   * @param entity Quality61850
   */
  protected void emitFindAllQuality61850(Quality61850 entity) {
    LOGGER.info("handling emitFindAllQuality61850");

    queryUpdateEmitter.emit(FindAllQuality61850Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(Quality61850Projector.class.getName());
}
