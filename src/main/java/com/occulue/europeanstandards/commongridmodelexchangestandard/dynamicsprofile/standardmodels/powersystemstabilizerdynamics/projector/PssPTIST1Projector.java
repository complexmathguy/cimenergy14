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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssPTIST1 as outlined for the CQRS pattern. All event handling and query handling
 * related to PssPTIST1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssPTIST1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssPTIST1")
@Component("pssPTIST1-projector")
public class PssPTIST1Projector extends PssPTIST1EntityProjector {

  // core constructor
  public PssPTIST1Projector(PssPTIST1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssPTIST1Event
   */
  @EventHandler(payloadType = CreatePssPTIST1Event.class)
  public void handle(CreatePssPTIST1Event event) {
    LOGGER.info("handling CreatePssPTIST1Event - " + event);
    PssPTIST1 entity = new PssPTIST1();
    entity.setPssPTIST1Id(event.getPssPTIST1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UpdatePssPTIST1Event
   */
  @EventHandler(payloadType = UpdatePssPTIST1Event.class)
  public void handle(UpdatePssPTIST1Event event) {
    LOGGER.info("handling UpdatePssPTIST1Event - " + event);

    PssPTIST1 entity = new PssPTIST1();
    entity.setPssPTIST1Id(event.getPssPTIST1Id());
    entity.setDtc(event.getDtc());
    entity.setDtf(event.getDtf());
    entity.setDtp(event.getDtp());
    entity.setK(event.getK());
    entity.setM(event.getM());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setTf(event.getTf());
    entity.setTp(event.getTp());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event DeletePssPTIST1Event
   */
  @EventHandler(payloadType = DeletePssPTIST1Event.class)
  public void handle(DeletePssPTIST1Event event) {
    LOGGER.info("handling DeletePssPTIST1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssPTIST1 entity = delete(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignDtcToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignDtcToPssPTIST1Event.class)
  public void handle(AssignDtcToPssPTIST1Event event) {
    LOGGER.info("handling AssignDtcToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignDtc(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignDtcFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignDtcFromPssPTIST1Event.class)
  public void handle(UnAssignDtcFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignDtcFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignDtc(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignDtfToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignDtfToPssPTIST1Event.class)
  public void handle(AssignDtfToPssPTIST1Event event) {
    LOGGER.info("handling AssignDtfToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignDtf(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignDtfFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignDtfFromPssPTIST1Event.class)
  public void handle(UnAssignDtfFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignDtfFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignDtf(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignDtpToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignDtpToPssPTIST1Event.class)
  public void handle(AssignDtpToPssPTIST1Event event) {
    LOGGER.info("handling AssignDtpToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignDtp(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignDtpFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignDtpFromPssPTIST1Event.class)
  public void handle(UnAssignDtpFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignDtpFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignDtp(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignKToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignKToPssPTIST1Event.class)
  public void handle(AssignKToPssPTIST1Event event) {
    LOGGER.info("handling AssignKToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignK(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignKFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignKFromPssPTIST1Event.class)
  public void handle(UnAssignKFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignKFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignK(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignMToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignMToPssPTIST1Event.class)
  public void handle(AssignMToPssPTIST1Event event) {
    LOGGER.info("handling AssignMToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignM(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignMFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignMFromPssPTIST1Event.class)
  public void handle(UnAssignMFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignMFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignM(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignT1ToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignT1ToPssPTIST1Event.class)
  public void handle(AssignT1ToPssPTIST1Event event) {
    LOGGER.info("handling AssignT1ToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignT1(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignT1FromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignT1FromPssPTIST1Event.class)
  public void handle(UnAssignT1FromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignT1FromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignT1(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignT2ToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignT2ToPssPTIST1Event.class)
  public void handle(AssignT2ToPssPTIST1Event event) {
    LOGGER.info("handling AssignT2ToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignT2(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignT2FromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignT2FromPssPTIST1Event.class)
  public void handle(UnAssignT2FromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignT2FromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignT2(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignT3ToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignT3ToPssPTIST1Event.class)
  public void handle(AssignT3ToPssPTIST1Event event) {
    LOGGER.info("handling AssignT3ToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignT3(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignT3FromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignT3FromPssPTIST1Event.class)
  public void handle(UnAssignT3FromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignT3FromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignT3(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignT4ToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignT4ToPssPTIST1Event.class)
  public void handle(AssignT4ToPssPTIST1Event event) {
    LOGGER.info("handling AssignT4ToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignT4(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignT4FromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignT4FromPssPTIST1Event.class)
  public void handle(UnAssignT4FromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignT4FromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignT4(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignTfToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignTfToPssPTIST1Event.class)
  public void handle(AssignTfToPssPTIST1Event event) {
    LOGGER.info("handling AssignTfToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignTf(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignTfFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignTfFromPssPTIST1Event.class)
  public void handle(UnAssignTfFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignTfFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignTf(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event AssignTpToPssPTIST1Event
   */
  @EventHandler(payloadType = AssignTpToPssPTIST1Event.class)
  public void handle(AssignTpToPssPTIST1Event event) {
    LOGGER.info("handling AssignTpToPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST1 entity = assignTp(event.getPssPTIST1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /*
   * @param	event UnAssignTpFromPssPTIST1Event
   */
  @EventHandler(payloadType = UnAssignTpFromPssPTIST1Event.class)
  public void handle(UnAssignTpFromPssPTIST1Event event) {
    LOGGER.info("handling UnAssignTpFromPssPTIST1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST1 entity = unAssignTp(event.getPssPTIST1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST1(entity);
  }

  /**
   * Method to retrieve the PssPTIST1 via an PssPTIST1PrimaryKey.
   *
   * @param id Long
   * @return PssPTIST1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssPTIST1 handle(FindPssPTIST1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssPTIST1Id());
  }

  /**
   * Method to retrieve a collection of all PssPTIST1s
   *
   * @param query FindAllPssPTIST1Query
   * @return List<PssPTIST1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssPTIST1> handle(FindAllPssPTIST1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssPTIST1, but only if the id matches
   *
   * @param entity PssPTIST1
   */
  protected void emitFindPssPTIST1(PssPTIST1 entity) {
    LOGGER.info("handling emitFindPssPTIST1");

    queryUpdateEmitter.emit(
        FindPssPTIST1Query.class,
        query -> query.getFilter().getPssPTIST1Id().equals(entity.getPssPTIST1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssPTIST1
   *
   * @param entity PssPTIST1
   */
  protected void emitFindAllPssPTIST1(PssPTIST1 entity) {
    LOGGER.info("handling emitFindAllPssPTIST1");

    queryUpdateEmitter.emit(FindAllPssPTIST1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssPTIST1Projector.class.getName());
}
