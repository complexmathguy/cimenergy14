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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * SvTapStep business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SvTapStep related services in the case of a SvTapStep business
 *       related service failing.
 *   <li>Exposes a simpler, uniform SvTapStep interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SvTapStep business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SvTapStepBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SvTapStepBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SvTapStep Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SvTapStepBusinessDelegate
   */
  public static SvTapStepBusinessDelegate getSvTapStepInstance() {
    return (new SvTapStepBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSvTapStep(CreateSvTapStepCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSvTapStepId() == null) command.setSvTapStepId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSvTapStepCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSvTapStepCommand of SvTapStep is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SvTapStep - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSvTapStepCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSvTapStep(UpdateSvTapStepCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSvTapStepCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SvTapStep - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSvTapStepCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSvTapStepCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSvTapStepCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SvTapStep using Id = " + command.getSvTapStepId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SvTapStep via SvTapStepFetchOneSummary
   *
   * @param summary SvTapStepFetchOneSummary
   * @return SvTapStepFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SvTapStep getSvTapStep(SvTapStepFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SvTapStepFetchOneSummary arg cannot be null");

    SvTapStep entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SvTapStep
      // --------------------------------------
      CompletableFuture<SvTapStep> futureEntity =
          queryGateway.query(
              new FindSvTapStepQuery(new LoadSvTapStepFilter(summary.getSvTapStepId())),
              ResponseTypes.instanceOf(SvTapStep.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SvTapStep with id " + summary.getSvTapStepId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SvTapSteps
   *
   * @return List<SvTapStep>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SvTapStep> getAllSvTapStep() throws ProcessingException {
    List<SvTapStep> list = null;

    try {
      CompletableFuture<List<SvTapStep>> futureList =
          queryGateway.query(
              new FindAllSvTapStepQuery(), ResponseTypes.multipleInstancesOf(SvTapStep.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SvTapStep";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Position on SvTapStep
   *
   * @param command AssignPositionToSvTapStepCommand
   * @exception ProcessingException
   */
  public void assignPosition(AssignPositionToSvTapStepCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvTapStepId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SvTapStepBusinessDelegate parentDelegate = SvTapStepBusinessDelegate.getSvTapStepInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Position on SvTapStep
   *
   * @param command UnAssignPositionFromSvTapStepCommand
   * @exception ProcessingException
   */
  public void unAssignPosition(UnAssignPositionFromSvTapStepCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Position on SvTapStep";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SvTapStep on SvTapStep
   *
   * @param command AssignSvTapStepToSvTapStepCommand
   * @exception ProcessingException
   */
  public void assignSvTapStep(AssignSvTapStepToSvTapStepCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvTapStepId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
            .statevariables.delegate.SvTapStepBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
                .statevariables.delegate.SvTapStepBusinessDelegate.getSvTapStepInstance();
    SvTapStepBusinessDelegate parentDelegate = SvTapStepBusinessDelegate.getSvTapStepInstance();
    UUID childId = command.getAssignment().getSvTapStepId();
    SvTapStep child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get SvTapStep using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SvTapStep on SvTapStep
   *
   * @param command UnAssignSvTapStepFromSvTapStepCommand
   * @exception ProcessingException
   */
  public void unAssignSvTapStep(UnAssignSvTapStepFromSvTapStepCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvTapStepValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SvTapStep on SvTapStep";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SvTapStep
   */
  private SvTapStep load(UUID id) throws ProcessingException {
    svTapStep =
        SvTapStepBusinessDelegate.getSvTapStepInstance()
            .getSvTapStep(new SvTapStepFetchOneSummary(id));
    return svTapStep;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SvTapStep svTapStep = null;
  private static final Logger LOGGER = Logger.getLogger(SvTapStepBusinessDelegate.class.getName());
}
