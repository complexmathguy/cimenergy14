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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcANS as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcANS are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcANSAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excANS")
@Component("excANS-projector")
public class ExcANSProjector extends ExcANSEntityProjector {

  // core constructor
  public ExcANSProjector(ExcANSRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcANSEvent
   */
  @EventHandler(payloadType = CreateExcANSEvent.class)
  public void handle(CreateExcANSEvent event) {
    LOGGER.info("handling CreateExcANSEvent - " + event);
    ExcANS entity = new ExcANS();
    entity.setExcANSId(event.getExcANSId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UpdateExcANSEvent
   */
  @EventHandler(payloadType = UpdateExcANSEvent.class)
  public void handle(UpdateExcANSEvent event) {
    LOGGER.info("handling UpdateExcANSEvent - " + event);

    ExcANS entity = new ExcANS();
    entity.setExcANSId(event.getExcANSId());
    entity.setBlint(event.getBlint());
    entity.setIfmn(event.getIfmn());
    entity.setIfmx(event.getIfmx());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setKce(event.getKce());
    entity.setKrvecc(event.getKrvecc());
    entity.setKvfif(event.getKvfif());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setTb(event.getTb());
    entity.setVrmn(event.getVrmn());
    entity.setVrmx(event.getVrmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event DeleteExcANSEvent
   */
  @EventHandler(payloadType = DeleteExcANSEvent.class)
  public void handle(DeleteExcANSEvent event) {
    LOGGER.info("handling DeleteExcANSEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcANS entity = delete(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignBlintToExcANSEvent
   */
  @EventHandler(payloadType = AssignBlintToExcANSEvent.class)
  public void handle(AssignBlintToExcANSEvent event) {
    LOGGER.info("handling AssignBlintToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignBlint(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignBlintFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignBlintFromExcANSEvent.class)
  public void handle(UnAssignBlintFromExcANSEvent event) {
    LOGGER.info("handling UnAssignBlintFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignBlint(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignIfmnToExcANSEvent
   */
  @EventHandler(payloadType = AssignIfmnToExcANSEvent.class)
  public void handle(AssignIfmnToExcANSEvent event) {
    LOGGER.info("handling AssignIfmnToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignIfmn(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignIfmnFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignIfmnFromExcANSEvent.class)
  public void handle(UnAssignIfmnFromExcANSEvent event) {
    LOGGER.info("handling UnAssignIfmnFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignIfmn(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignIfmxToExcANSEvent
   */
  @EventHandler(payloadType = AssignIfmxToExcANSEvent.class)
  public void handle(AssignIfmxToExcANSEvent event) {
    LOGGER.info("handling AssignIfmxToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignIfmx(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignIfmxFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignIfmxFromExcANSEvent.class)
  public void handle(UnAssignIfmxFromExcANSEvent event) {
    LOGGER.info("handling UnAssignIfmxFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignIfmx(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignK2ToExcANSEvent
   */
  @EventHandler(payloadType = AssignK2ToExcANSEvent.class)
  public void handle(AssignK2ToExcANSEvent event) {
    LOGGER.info("handling AssignK2ToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignK2(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignK2FromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignK2FromExcANSEvent.class)
  public void handle(UnAssignK2FromExcANSEvent event) {
    LOGGER.info("handling UnAssignK2FromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignK2(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignK3ToExcANSEvent
   */
  @EventHandler(payloadType = AssignK3ToExcANSEvent.class)
  public void handle(AssignK3ToExcANSEvent event) {
    LOGGER.info("handling AssignK3ToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignK3(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignK3FromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignK3FromExcANSEvent.class)
  public void handle(UnAssignK3FromExcANSEvent event) {
    LOGGER.info("handling UnAssignK3FromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignK3(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignKceToExcANSEvent
   */
  @EventHandler(payloadType = AssignKceToExcANSEvent.class)
  public void handle(AssignKceToExcANSEvent event) {
    LOGGER.info("handling AssignKceToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignKce(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignKceFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignKceFromExcANSEvent.class)
  public void handle(UnAssignKceFromExcANSEvent event) {
    LOGGER.info("handling UnAssignKceFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignKce(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignKrveccToExcANSEvent
   */
  @EventHandler(payloadType = AssignKrveccToExcANSEvent.class)
  public void handle(AssignKrveccToExcANSEvent event) {
    LOGGER.info("handling AssignKrveccToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignKrvecc(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignKrveccFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignKrveccFromExcANSEvent.class)
  public void handle(UnAssignKrveccFromExcANSEvent event) {
    LOGGER.info("handling UnAssignKrveccFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignKrvecc(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignKvfifToExcANSEvent
   */
  @EventHandler(payloadType = AssignKvfifToExcANSEvent.class)
  public void handle(AssignKvfifToExcANSEvent event) {
    LOGGER.info("handling AssignKvfifToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignKvfif(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignKvfifFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignKvfifFromExcANSEvent.class)
  public void handle(UnAssignKvfifFromExcANSEvent event) {
    LOGGER.info("handling UnAssignKvfifFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignKvfif(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignT1ToExcANSEvent
   */
  @EventHandler(payloadType = AssignT1ToExcANSEvent.class)
  public void handle(AssignT1ToExcANSEvent event) {
    LOGGER.info("handling AssignT1ToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignT1(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignT1FromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignT1FromExcANSEvent.class)
  public void handle(UnAssignT1FromExcANSEvent event) {
    LOGGER.info("handling UnAssignT1FromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignT1(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignT2ToExcANSEvent
   */
  @EventHandler(payloadType = AssignT2ToExcANSEvent.class)
  public void handle(AssignT2ToExcANSEvent event) {
    LOGGER.info("handling AssignT2ToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignT2(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignT2FromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignT2FromExcANSEvent.class)
  public void handle(UnAssignT2FromExcANSEvent event) {
    LOGGER.info("handling UnAssignT2FromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignT2(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignT3ToExcANSEvent
   */
  @EventHandler(payloadType = AssignT3ToExcANSEvent.class)
  public void handle(AssignT3ToExcANSEvent event) {
    LOGGER.info("handling AssignT3ToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignT3(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignT3FromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignT3FromExcANSEvent.class)
  public void handle(UnAssignT3FromExcANSEvent event) {
    LOGGER.info("handling UnAssignT3FromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignT3(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignTbToExcANSEvent
   */
  @EventHandler(payloadType = AssignTbToExcANSEvent.class)
  public void handle(AssignTbToExcANSEvent event) {
    LOGGER.info("handling AssignTbToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignTb(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignTbFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcANSEvent.class)
  public void handle(UnAssignTbFromExcANSEvent event) {
    LOGGER.info("handling UnAssignTbFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignTb(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignVrmnToExcANSEvent
   */
  @EventHandler(payloadType = AssignVrmnToExcANSEvent.class)
  public void handle(AssignVrmnToExcANSEvent event) {
    LOGGER.info("handling AssignVrmnToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignVrmn(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignVrmnFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignVrmnFromExcANSEvent.class)
  public void handle(UnAssignVrmnFromExcANSEvent event) {
    LOGGER.info("handling UnAssignVrmnFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignVrmn(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event AssignVrmxToExcANSEvent
   */
  @EventHandler(payloadType = AssignVrmxToExcANSEvent.class)
  public void handle(AssignVrmxToExcANSEvent event) {
    LOGGER.info("handling AssignVrmxToExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcANS entity = assignVrmx(event.getExcANSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /*
   * @param	event UnAssignVrmxFromExcANSEvent
   */
  @EventHandler(payloadType = UnAssignVrmxFromExcANSEvent.class)
  public void handle(UnAssignVrmxFromExcANSEvent event) {
    LOGGER.info("handling UnAssignVrmxFromExcANSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcANS entity = unAssignVrmx(event.getExcANSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcANS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcANS(entity);
  }

  /**
   * Method to retrieve the ExcANS via an ExcANSPrimaryKey.
   *
   * @param id Long
   * @return ExcANS
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcANS handle(FindExcANSQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcANSId());
  }

  /**
   * Method to retrieve a collection of all ExcANSs
   *
   * @param query FindAllExcANSQuery
   * @return List<ExcANS>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcANS> handle(FindAllExcANSQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcANS, but only if the id matches
   *
   * @param entity ExcANS
   */
  protected void emitFindExcANS(ExcANS entity) {
    LOGGER.info("handling emitFindExcANS");

    queryUpdateEmitter.emit(
        FindExcANSQuery.class,
        query -> query.getFilter().getExcANSId().equals(entity.getExcANSId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcANS
   *
   * @param entity ExcANS
   */
  protected void emitFindAllExcANS(ExcANS entity) {
    LOGGER.info("handling emitFindAllExcANS");

    queryUpdateEmitter.emit(FindAllExcANSQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcANSProjector.class.getName());
}
