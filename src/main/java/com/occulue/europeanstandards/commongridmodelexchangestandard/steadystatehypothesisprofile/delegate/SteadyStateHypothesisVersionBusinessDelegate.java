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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.validator.*;
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
 * SteadyStateHypothesisVersion business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SteadyStateHypothesisVersion related services in the case of a
 *       SteadyStateHypothesisVersion business related service failing.
 *   <li>Exposes a simpler, uniform SteadyStateHypothesisVersion interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       SteadyStateHypothesisVersion business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SteadyStateHypothesisVersionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SteadyStateHypothesisVersionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SteadyStateHypothesisVersion Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SteadyStateHypothesisVersionBusinessDelegate
   */
  public static SteadyStateHypothesisVersionBusinessDelegate
      getSteadyStateHypothesisVersionInstance() {
    return (new SteadyStateHypothesisVersionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSteadyStateHypothesisVersion(
      CreateSteadyStateHypothesisVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSteadyStateHypothesisVersionId() == null)
        command.setSteadyStateHypothesisVersionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSteadyStateHypothesisVersionCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSteadyStateHypothesisVersionCommand of SteadyStateHypothesisVersion is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SteadyStateHypothesisVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSteadyStateHypothesisVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSteadyStateHypothesisVersion(
      UpdateSteadyStateHypothesisVersionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSteadyStateHypothesisVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SteadyStateHypothesisVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSteadyStateHypothesisVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSteadyStateHypothesisVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSteadyStateHypothesisVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SteadyStateHypothesisVersion using Id = "
              + command.getSteadyStateHypothesisVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SteadyStateHypothesisVersion via
   * SteadyStateHypothesisVersionFetchOneSummary
   *
   * @param summary SteadyStateHypothesisVersionFetchOneSummary
   * @return SteadyStateHypothesisVersionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SteadyStateHypothesisVersion getSteadyStateHypothesisVersion(
      SteadyStateHypothesisVersionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "SteadyStateHypothesisVersionFetchOneSummary arg cannot be null");

    SteadyStateHypothesisVersion entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SteadyStateHypothesisVersion
      // --------------------------------------
      CompletableFuture<SteadyStateHypothesisVersion> futureEntity =
          queryGateway.query(
              new FindSteadyStateHypothesisVersionQuery(
                  new LoadSteadyStateHypothesisVersionFilter(
                      summary.getSteadyStateHypothesisVersionId())),
              ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SteadyStateHypothesisVersion with id "
              + summary.getSteadyStateHypothesisVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SteadyStateHypothesisVersions
   *
   * @return List<SteadyStateHypothesisVersion>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SteadyStateHypothesisVersion> getAllSteadyStateHypothesisVersion()
      throws ProcessingException {
    List<SteadyStateHypothesisVersion> list = null;

    try {
      CompletableFuture<List<SteadyStateHypothesisVersion>> futureList =
          queryGateway.query(
              new FindAllSteadyStateHypothesisVersionQuery(),
              ResponseTypes.multipleInstancesOf(SteadyStateHypothesisVersion.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BaseUML on SteadyStateHypothesisVersion
   *
   * @param command AssignBaseUMLToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseUML(AssignBaseUMLToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BaseUML on SteadyStateHypothesisVersion
   *
   * @param command UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseUML(UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseUML on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BaseURI on SteadyStateHypothesisVersion
   *
   * @param command AssignBaseURIToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseURI(AssignBaseURIToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BaseURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignBaseURIFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseURI(UnAssignBaseURIFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseURI on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Date on SteadyStateHypothesisVersion
   *
   * @param command AssignDateToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignDate(AssignDateToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateProxyBusinessDelegate.getDateProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getDateProxyId();
    DateProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Date on SteadyStateHypothesisVersion
   *
   * @param command UnAssignDateFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDate(UnAssignDateFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Date on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign DifferenceModelURI on SteadyStateHypothesisVersion
   *
   * @param command AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignDifferenceModelURI(
      AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign DifferenceModelURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDifferenceModelURI(
      UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign DifferenceModelURI on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeUML on SteadyStateHypothesisVersion
   *
   * @param command AssignEntsoeUMLToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeUML(AssignEntsoeUMLToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeUML on SteadyStateHypothesisVersion
   *
   * @param command UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeUML(UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeUML on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeURI on SteadyStateHypothesisVersion
   *
   * @param command AssignEntsoeURIToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeURI(AssignEntsoeURIToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeURI(UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeURI on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ModelDescriptionURI on SteadyStateHypothesisVersion
   *
   * @param command AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignModelDescriptionURI(
      AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ModelDescriptionURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignModelDescriptionURI(
      UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ModelDescriptionURI on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceRDF on SteadyStateHypothesisVersion
   *
   * @param command AssignNamespaceRDFToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceRDF(AssignNamespaceRDFToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceRDF on SteadyStateHypothesisVersion
   *
   * @param command UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceRDF(
      UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceRDF on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceUML on SteadyStateHypothesisVersion
   *
   * @param command AssignNamespaceUMLToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceUML(AssignNamespaceUMLToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceUML on SteadyStateHypothesisVersion
   *
   * @param command UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceUML(
      UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceUML on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on SteadyStateHypothesisVersion
   *
   * @param command AssignShortNameToSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSteadyStateHypothesisVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    SteadyStateHypothesisVersionBusinessDelegate parentDelegate =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ShortName on SteadyStateHypothesisVersion
   *
   * @param command UnAssignShortNameFromSteadyStateHypothesisVersionCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromSteadyStateHypothesisVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SteadyStateHypothesisVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on SteadyStateHypothesisVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SteadyStateHypothesisVersion
   */
  private SteadyStateHypothesisVersion load(UUID id) throws ProcessingException {
    steadyStateHypothesisVersion =
        SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
            .getSteadyStateHypothesisVersion(new SteadyStateHypothesisVersionFetchOneSummary(id));
    return steadyStateHypothesisVersion;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SteadyStateHypothesisVersion steadyStateHypothesisVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(SteadyStateHypothesisVersionBusinessDelegate.class.getName());
}
