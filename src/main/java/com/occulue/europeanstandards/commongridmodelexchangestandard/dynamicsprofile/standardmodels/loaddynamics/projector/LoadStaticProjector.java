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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadStatic as outlined for the CQRS pattern. All event handling and query handling
 * related to LoadStatic are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by LoadStaticAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("loadStatic")
@Component("loadStatic-projector")
public class LoadStaticProjector extends LoadStaticEntityProjector {

  // core constructor
  public LoadStaticProjector(
      LoadStaticRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLoadStaticEvent
   */
  @EventHandler(payloadType = CreateLoadStaticEvent.class)
  public void handle(CreateLoadStaticEvent event) {
    LOGGER.info("handling CreateLoadStaticEvent - " + event);
    LoadStatic entity = new LoadStatic();
    entity.setLoadStaticId(event.getLoadStaticId());
    entity.setStaticLoadModelType(event.getStaticLoadModelType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UpdateLoadStaticEvent
   */
  @EventHandler(payloadType = UpdateLoadStaticEvent.class)
  public void handle(UpdateLoadStaticEvent event) {
    LOGGER.info("handling UpdateLoadStaticEvent - " + event);

    LoadStatic entity = new LoadStatic();
    entity.setLoadStaticId(event.getLoadStaticId());
    entity.setEp1(event.getEp1());
    entity.setEp2(event.getEp2());
    entity.setEp3(event.getEp3());
    entity.setEq1(event.getEq1());
    entity.setEq2(event.getEq2());
    entity.setEq3(event.getEq3());
    entity.setKp1(event.getKp1());
    entity.setKp2(event.getKp2());
    entity.setKp3(event.getKp3());
    entity.setKp4(event.getKp4());
    entity.setKpf(event.getKpf());
    entity.setKq1(event.getKq1());
    entity.setKq2(event.getKq2());
    entity.setKq3(event.getKq3());
    entity.setKq4(event.getKq4());
    entity.setKqf(event.getKqf());
    entity.setStaticLoadModelType(event.getStaticLoadModelType());
    entity.setLoadStatic(event.getLoadStatic());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event DeleteLoadStaticEvent
   */
  @EventHandler(payloadType = DeleteLoadStaticEvent.class)
  public void handle(DeleteLoadStaticEvent event) {
    LOGGER.info("handling DeleteLoadStaticEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    LoadStatic entity = delete(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignEp1ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignEp1ToLoadStaticEvent.class)
  public void handle(AssignEp1ToLoadStaticEvent event) {
    LOGGER.info("handling AssignEp1ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignEp1(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignEp1FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignEp1FromLoadStaticEvent.class)
  public void handle(UnAssignEp1FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignEp1FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignEp1(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignEp2ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignEp2ToLoadStaticEvent.class)
  public void handle(AssignEp2ToLoadStaticEvent event) {
    LOGGER.info("handling AssignEp2ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignEp2(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignEp2FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignEp2FromLoadStaticEvent.class)
  public void handle(UnAssignEp2FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignEp2FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignEp2(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignEp3ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignEp3ToLoadStaticEvent.class)
  public void handle(AssignEp3ToLoadStaticEvent event) {
    LOGGER.info("handling AssignEp3ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignEp3(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignEp3FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignEp3FromLoadStaticEvent.class)
  public void handle(UnAssignEp3FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignEp3FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignEp3(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignEq1ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignEq1ToLoadStaticEvent.class)
  public void handle(AssignEq1ToLoadStaticEvent event) {
    LOGGER.info("handling AssignEq1ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignEq1(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignEq1FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignEq1FromLoadStaticEvent.class)
  public void handle(UnAssignEq1FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignEq1FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignEq1(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignEq2ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignEq2ToLoadStaticEvent.class)
  public void handle(AssignEq2ToLoadStaticEvent event) {
    LOGGER.info("handling AssignEq2ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignEq2(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignEq2FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignEq2FromLoadStaticEvent.class)
  public void handle(UnAssignEq2FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignEq2FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignEq2(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignEq3ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignEq3ToLoadStaticEvent.class)
  public void handle(AssignEq3ToLoadStaticEvent event) {
    LOGGER.info("handling AssignEq3ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignEq3(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignEq3FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignEq3FromLoadStaticEvent.class)
  public void handle(UnAssignEq3FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignEq3FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignEq3(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKp1ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKp1ToLoadStaticEvent.class)
  public void handle(AssignKp1ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKp1ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKp1(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKp1FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKp1FromLoadStaticEvent.class)
  public void handle(UnAssignKp1FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKp1FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKp1(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKp2ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKp2ToLoadStaticEvent.class)
  public void handle(AssignKp2ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKp2ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKp2(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKp2FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKp2FromLoadStaticEvent.class)
  public void handle(UnAssignKp2FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKp2FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKp2(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKp3ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKp3ToLoadStaticEvent.class)
  public void handle(AssignKp3ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKp3ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKp3(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKp3FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKp3FromLoadStaticEvent.class)
  public void handle(UnAssignKp3FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKp3FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKp3(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKp4ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKp4ToLoadStaticEvent.class)
  public void handle(AssignKp4ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKp4ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKp4(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKp4FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKp4FromLoadStaticEvent.class)
  public void handle(UnAssignKp4FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKp4FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKp4(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKpfToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKpfToLoadStaticEvent.class)
  public void handle(AssignKpfToLoadStaticEvent event) {
    LOGGER.info("handling AssignKpfToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKpf(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKpfFromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKpfFromLoadStaticEvent.class)
  public void handle(UnAssignKpfFromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKpfFromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKpf(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKq1ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKq1ToLoadStaticEvent.class)
  public void handle(AssignKq1ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKq1ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKq1(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKq1FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKq1FromLoadStaticEvent.class)
  public void handle(UnAssignKq1FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKq1FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKq1(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKq2ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKq2ToLoadStaticEvent.class)
  public void handle(AssignKq2ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKq2ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKq2(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKq2FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKq2FromLoadStaticEvent.class)
  public void handle(UnAssignKq2FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKq2FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKq2(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKq3ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKq3ToLoadStaticEvent.class)
  public void handle(AssignKq3ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKq3ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKq3(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKq3FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKq3FromLoadStaticEvent.class)
  public void handle(UnAssignKq3FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKq3FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKq3(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKq4ToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKq4ToLoadStaticEvent.class)
  public void handle(AssignKq4ToLoadStaticEvent event) {
    LOGGER.info("handling AssignKq4ToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKq4(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKq4FromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKq4FromLoadStaticEvent.class)
  public void handle(UnAssignKq4FromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKq4FromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKq4(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignKqfToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignKqfToLoadStaticEvent.class)
  public void handle(AssignKqfToLoadStaticEvent event) {
    LOGGER.info("handling AssignKqfToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignKqf(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignKqfFromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignKqfFromLoadStaticEvent.class)
  public void handle(UnAssignKqfFromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignKqfFromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignKqf(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event AssignLoadStaticToLoadStaticEvent
   */
  @EventHandler(payloadType = AssignLoadStaticToLoadStaticEvent.class)
  public void handle(AssignLoadStaticToLoadStaticEvent event) {
    LOGGER.info("handling AssignLoadStaticToLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadStatic entity = assignLoadStatic(event.getLoadStaticId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /*
   * @param	event UnAssignLoadStaticFromLoadStaticEvent
   */
  @EventHandler(payloadType = UnAssignLoadStaticFromLoadStaticEvent.class)
  public void handle(UnAssignLoadStaticFromLoadStaticEvent event) {
    LOGGER.info("handling UnAssignLoadStaticFromLoadStaticEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadStatic entity = unAssignLoadStatic(event.getLoadStaticId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadStatic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadStatic(entity);
  }

  /**
   * Method to retrieve the LoadStatic via an LoadStaticPrimaryKey.
   *
   * @param id Long
   * @return LoadStatic
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public LoadStatic handle(FindLoadStaticQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLoadStaticId());
  }

  /**
   * Method to retrieve a collection of all LoadStatics
   *
   * @param query FindAllLoadStaticQuery
   * @return List<LoadStatic>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<LoadStatic> handle(FindAllLoadStaticQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLoadStatic, but only if the id matches
   *
   * @param entity LoadStatic
   */
  protected void emitFindLoadStatic(LoadStatic entity) {
    LOGGER.info("handling emitFindLoadStatic");

    queryUpdateEmitter.emit(
        FindLoadStaticQuery.class,
        query -> query.getFilter().getLoadStaticId().equals(entity.getLoadStaticId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLoadStatic
   *
   * @param entity LoadStatic
   */
  protected void emitFindAllLoadStatic(LoadStatic entity) {
    LOGGER.info("handling emitFindAllLoadStatic");

    queryUpdateEmitter.emit(FindAllLoadStaticQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(LoadStaticProjector.class.getName());
}
